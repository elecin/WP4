// $Id: OPgetlocationM.nc,v 1.11 2006/04/25 22:27:38 chien-liang Exp $

/* Agilla - A middleware for wireless sensor networks.
 * Copyright (C) 2006, Washington University in Saint Louis
 * By Chien-Liang Fok.
 *
 * Washington University states that Agilla is free software;
 * you can redistribute it and/or modify it under the terms of
 * the current version of the GNU Lesser General Public License
 * as published by the Free Software Foundation.
 *
 * Agilla is distributed in the hope that it will be useful, but
 * THERE ARE NO WARRANTIES, WHETHER ORAL OR WRITTEN, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO, IMPLIED WARRANTIES OF
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR USE.
 *
 * YOU UNDERSTAND THAT AGILLA IS PROVIDED "AS IS" FOR WHICH NO
 * WARRANTIES AS TO CAPABILITIES OR ACCURACY ARE MADE. THERE ARE NO
 * WARRANTIES AND NO REPRESENTATION THAT AGILLA IS FREE OF
 * INFRINGEMENT OF THIRD PARTY PATENT, COPYRIGHT, OR OTHER
 * PROPRIETARY RIGHTS.	THERE ARE NO WARRANTIES THAT SOFTWARE IS
 * FREE FROM "BUGS", "VIRUSES", "TROJAN HORSES", "TRAP DOORS", "WORMS",
 * OR OTHER HARMFUL CODE.
 *
 * YOU ASSUME THE ENTIRE RISK AS TO THE PERFORMANCE OF SOFTWARE AND/OR
 * ASSOCIATED MATERIALS, AND TO THE PERFORMANCE AND VALIDITY OF
 * INFORMATION GENERATED USING SOFTWARE. By using Agilla you agree to
 * indemnify, defend, and hold harmless WU, its employees, officers and
 * agents from any and all claims, costs, or liabilities, including
 * attorneys fees and court costs at both the trial and appellate levels
 * for any loss, damage, or injury caused by your actions or actions of
 * your officers, servants, agents or third parties acting on behalf or
 * under authorization from you, as a result of using Agilla.
 *
 * See the GNU Lesser General Public License for more details, which can
 * be found here: http://www.gnu.org/copyleft/lesser.html
 */

#include "Agilla.h"
#include "AgillaOpcodes.h"
#include "TupleSpace.h"
#include "Timer.h"

/**
 * Finds the location of an agent using its AgentID.
 *
 * @author Chien-Liang Fok
 */
module OPgetlocationM {
	provides {
	interface BytecodeI;

	interface Init;
	}
	uses {
	interface NeighborListI;
	interface LocationMgrI;

	interface AMSend as SendRequest;
	interface Receive as ReceiveRequest;
	interface AMSend as SerialSendRequest;
	interface Receive as SerialReceiveRequest;

	interface Receive as ReceiveResults;
	interface AMSend as SendResults;
	interface AMSend as SerialSendResults;
	interface Receive as SerialReceiveResults;

	interface MessageBufferI;
	interface AddressMgrI;
	interface AgentMgrI;
	interface TupleUtilI;
	interface OpStackI;
	interface QueueI;
	interface ErrorMgrI;
	interface Timer<TMilli> as Timeout;
	interface Leds; // debug
	interface Packet;

	#if ENABLE_EXP_LOGGING
		interface ExpLoggerI;
		#ifdef _H_msp430hardware_h
		interface LocalTime;
		#endif
	#endif
	}
}
implementation {

	/**
	 * Only one agent per mote can issue a directory service
	 * operation, _currAgent is a pointer to this agent's context.
	 * If another agent attempts to perform a directory service
	 * operation while the _currAgent is waiting for results,
	 * it's context is stored in the waitQueue and resumed when
	 * the current agent finishes.
	 */
	AgillaAgentContext* _currAgent;

	/**
	 * The AgentID of the agent being searched for.
	 */
	AgillaAgentID _aID;

	/**
	 * Holds pending agents that are waiting for the current agent
	 * to finish.
	 */
	Queue waitQueue;

	/**
	 * A running counter for the query id.
	 */
	uint8_t _qid;


	#if ENABLE_EXP_LOGGING
	uint32_t _start;
	#endif

	command error_t Init.init()
	{
	_currAgent = NULL;
	_qid = 0;
	call QueueI.init(&waitQueue);
	return SUCCESS;
	}

	/*command error_t StdControl.start() {
	return SUCCESS;
	}

	command error_t StdControl.stop() {
	return SUCCESS;
	}*/

	inline error_t finish(error_t success)
	{
	#if ENABLE_EXP_LOGGING
		if (success == SUCCESS) {
		#ifdef _H_msp430hardware_h
			_start = call LocalTime.get() - _start;
		#else
			_start = 0;
		#endif
		} else {
		_start = 0;
		}
		call ExpLoggerI.sendQueryLatency(_start);
	#endif

	if(success==SUCCESS) _currAgent->condition=1;
		else _currAgent->condition=0;
	call AgentMgrI.run(_currAgent);
	_currAgent = NULL;

	// If there are pending agents, execute them
	if (!call QueueI.empty(&waitQueue))
	{
		#if DEBUG_OP_GETLOCATION
		dbg("DBG_USR1", "OPgetlocationM: finish(): WaitQueue (0x%x) not empty, running next agent.\n", &waitQueue);
		#endif

		call AgentMgrI.run(call QueueI.dequeue(NULL, &waitQueue));
	}
	return SUCCESS;
	} // finish()


	/**
	 * Figures out what the next hop should be towards the base station and
	 * sends the message to that node.	If this node is the gateway, the message
	 * is forwarded to the UART.
	 */

	inline error_t sendQueryMsg(message_t* msg)
	{

	if (call AddressMgrI.isGW() == SUCCESS)
	{
		#if DEBUG_OP_GETLOCATION
		dbg("DBG_USR1", "OPgetLocationM: sendQueryMsg(): Sending query message to the BS\n");
		#endif
		return call SerialSendRequest.send(AM_UART_ADDR, msg, sizeof(AgillaQueryAgentLocMsg));
	} else
	{
		uint16_t onehop_dest;

		// Get the one-hop neighbor that is closest to the gateway.
		// If there is no known gateway, abort.
		if (call NeighborListI.getGW(&onehop_dest) == NO_GW)
		{
		dbg("DBG_USR1", "OPgetLocationM: ERROR: No neighbor closer to a gateway.\n");
		return FAIL;
		}
		 
		 if (onehop_dest == AM_UART_ADDR)
		return call SerialSendRequest.send(onehop_dest, msg, sizeof(AgillaQueryAgentLocMsg));
		else
		return call SendRequest.send(onehop_dest, msg, sizeof(AgillaQueryAgentLocMsg));
	}
	} // sendQueryMsg()

	/**
	 * Starts the sending of a location update message.
	 */
	task void doSendQuery()
	{
	message_t* msg = call MessageBufferI.getMsg();
	if (msg != NULL)
	{
		AgillaQueryAgentLocMsg *qMsg = (AgillaQueryAgentLocMsg *)(call Packet.getPayload(msg, sizeof(AgillaQueryAgentLocMsg)));
		qMsg->agent_id = _currAgent->id;
		qMsg->src = TOS_NODE_ID;
		qMsg->dest = AM_UART_ADDR;
		qMsg->qid = ((TOS_NODE_ID & 0xff) << 8) | _qid++;
		qMsg->find_agent_id = _aID;

		if (sendQueryMsg(msg) != SUCCESS)
		call MessageBufferI.freeMsg(msg);
		else {
		#if ENABLE_EXP_LOGGING
			AgillaLocation loc;
			loc.x = loc.y = 0;
			call ExpLoggerI.sendTraceQid(_currAgent->id.id, TOS_NODE_ID, QUERY_GET_LOCATION_ISSUED, qMsg->qid, qMsg->find_agent_id.id, loc);
			#ifdef _H_msp430hardware_h
			_start = call LocalTime.get();
			#endif
		#endif
		call Timeout.startOneShot(TIMEOUT_GET_LOCATION);
		}

	}
	} // task doSendQuery()

	/**
	 * Execute a directory operation.
	 *
	 * @param instr The directory operation instruction.
	 * @param context The agent performing the operation.
	 * @return SUCCESS If the operation is being perfomed.
	 */
	command error_t BytecodeI.execute(uint8_t instr, AgillaAgentContext* context)
	{
	// Change the context's state to WAITING.	This prevents the VM
	// from executing the agent.
	context->state = AGILLA_STATE_WAITING;

	// Mutual Exclusion.	Only allow one agent to perform
	// a remote tuple space operation at a time.
	if (_currAgent != NULL)
	{
		#if DEBUG_OP_GETLOCATION
		dbg("DBG_USR1", "OPgetlocationM: execute(): Another agent is performing a directory operation, waiting...\n");
		#endif

		context->pc--;
		return call QueueI.enqueue(context, &waitQueue, context);
	} else
	{
		AgillaVariable var;

		_currAgent = context;

		dbg("DBG_USR1", "VM (%i:%i): Executing OPgetlocation.\n", context->id.id, context->pc-1);

		// Get the AgentID
		if (call OpStackI.popOperand(_currAgent, &var) == SUCCESS)
		{
		if (var.vtype & AGILLA_VAR_A) {
			_aID = var.id;

		} else if (var.vtype & AGILLA_VAR_V)
		{
			_aID.id = var.value.value;
		}
		else
		{
			dbg("DBG_USR1", "VM (%i:%i): OPgetlocationM: ERROR: Invalid parameter type [%i].\n",

			_currAgent->id.id, _currAgent->pc-1, var.vtype);
			call ErrorMgrI.error2d(_currAgent, AGILLA_ERROR_INVALID_TYPE, 0x12, var.vtype);
			return finish(FAIL);
		}
		} else
		{
		dbg("DBG_USR1", "VM (%i:%i): OPgetlocationM: ERROR: Could not pop parameter off stack.\n",
			_currAgent->id.id, _currAgent->pc-1);
		return finish(FAIL);
		}

		#if DEBUG_OP_GETLOCATION
		dbg("DBG_USR1", "OPgetlocationM: Searching for agent with ID = %i\n", _aID.id);
		#endif

		if (post doSendQuery() != SUCCESS)
		finish(FAIL);
		return SUCCESS;
	}
	} // BytecodeI.execute

	/**
	 * Bounces a message off this mote.
	 */
	event message_t* ReceiveResults.receive(message_t* m, void* payload, uint8_t len)
	{
	AgillaQueryReplyAgentLocMsg* reply = (AgillaQueryReplyAgentLocMsg*)payload;

	if (reply->dest == TOS_NODE_ID)
	{
		if (_currAgent != NULL && _currAgent->id.id == reply->agent_id.id)
		{
		#if DEBUG_OP_GETLOCATION

			dbg("DBG_USR1", "OPgetlocationM: Received Results (%i, %i)\n", reply->loc.x, reply->loc.y);
		#endif

		call Timeout.stop();

		//if (reply->loc.x == 0 && reply->loc.y == 0)

		call OpStackI.pushLocation(_currAgent, &reply->loc);

		#if ENABLE_EXP_LOGGING
			call ExpLoggerI.sendTraceQid(_currAgent->id.id, TOS_NODE_ID, 
			QUERY_GET_LOCATION_RESULTS_RECEIVED, reply->qid, SUCCESS, reply->loc);
		#endif

		finish(SUCCESS);
		}
	} else
	{
		// forward the results to the node closest to the destination
		message_t* msg = call MessageBufferI.getMsg();
		if (msg != NULL)
		{
		uint16_t oneHopDest = reply->dest;

		#if ENABLE_GRID_ROUTING
			call NeighborListI.getClosestNeighbor(&oneHopDest);
		#endif

		#if DEBUG_OP_GETLOCATION
			dbg("DBG_USR1", "OPgetlocationM: Forwarding results (%i,%i) to %i\n",
				reply->loc.x, reply->loc.y, oneHopDest);
		#endif

		*msg = *m;
		if(oneHopDest == AM_UART_ADDR){
			if (call SerialSendResults.send(oneHopDest, msg, sizeof(AgillaQueryReplyAgentLocMsg)) != SUCCESS){
			call MessageBufferI.freeMsg(msg);
			} else 
			{
			#if ENABLE_EXP_LOGGING
				call ExpLoggerI.sendTraceQid(reply->agent_id.id, TOS_NODE_ID, QUERY_GET_LOCATION_RESULTS_FORWARDED, 
				reply->qid, reply->dest, reply->loc);
			#endif		
			}
		}
		else{
			if (call SendResults.send(oneHopDest, msg, sizeof(AgillaQueryReplyAgentLocMsg)) != SUCCESS){
			call MessageBufferI.freeMsg(msg);
			} else 
			{
			#if ENABLE_EXP_LOGGING
				call ExpLoggerI.sendTraceQid(reply->agent_id.id, TOS_NODE_ID, QUERY_GET_LOCATION_RESULTS_FORWARDED, 
				reply->qid, reply->dest, reply->loc);
			#endif		
			}
		}
		}
	}
	return m;
	}

	//RECEIVE SERIAL
	event message_t* SerialReceiveResults.receive(message_t* m, void* payload, uint8_t len)
	{
	AgillaQueryReplyAgentLocMsg* reply = (AgillaQueryReplyAgentLocMsg*)payload;

	if (reply->dest == TOS_NODE_ID)
	{
		if (_currAgent != NULL && _currAgent->id.id == reply->agent_id.id)
		{
		#if DEBUG_OP_GETLOCATION

			dbg("DBG_USR1", "OPgetlocationM: Received Results (%i, %i)\n", reply->loc.x, reply->loc.y);
		#endif

		call Timeout.stop();

		//if (reply->loc.x == 0 && reply->loc.y == 0)

		call OpStackI.pushLocation(_currAgent, &reply->loc);

		#if ENABLE_EXP_LOGGING
			call ExpLoggerI.sendTraceQid(_currAgent->id.id, TOS_NODE_ID, 
			QUERY_GET_LOCATION_RESULTS_RECEIVED, reply->qid, SUCCESS, reply->loc);
		#endif

		finish(SUCCESS);
		}
	} else
	{
		// forward the results to the node closest to the destination
		message_t* msg = call MessageBufferI.getMsg();
		if (msg != NULL)
		{
		uint16_t oneHopDest = reply->dest;

		#if ENABLE_GRID_ROUTING
			call NeighborListI.getClosestNeighbor(&oneHopDest);
		#endif

		#if DEBUG_OP_GETLOCATION
			dbg("DBG_USR1", "OPgetlocationM: Forwarding results (%i,%i) to %i\n",
				reply->loc.x, reply->loc.y, oneHopDest);
		#endif

		*msg = *m;
		if(oneHopDest == AM_UART_ADDR){
			if (call SerialSendResults.send(oneHopDest, msg, sizeof(AgillaQueryReplyAgentLocMsg)) != SUCCESS){
			call MessageBufferI.freeMsg(msg);
			} else 
			{
			#if ENABLE_EXP_LOGGING
				call ExpLoggerI.sendTraceQid(reply->agent_id.id, TOS_NODE_ID, QUERY_GET_LOCATION_RESULTS_FORWARDED, 
				reply->qid, reply->dest, reply->loc);
			#endif		
			}
		}
		else{
			if (call SendResults.send(oneHopDest, msg, sizeof(AgillaQueryReplyAgentLocMsg)) != SUCCESS){
			call MessageBufferI.freeMsg(msg);
			} else 
			{
			#if ENABLE_EXP_LOGGING
				call ExpLoggerI.sendTraceQid(reply->agent_id.id, TOS_NODE_ID, QUERY_GET_LOCATION_RESULTS_FORWARDED, 
				reply->qid, reply->dest, reply->loc);
			#endif		
			}
		}
		}
	}
	return m;
	}

	event void Timeout.fired()
	{
	#if ENABLE_EXP_LOGGING
		AgillaLocation loc;
		call LocationMgrI.getLocation(TOS_NODE_ID, &loc);
		call ExpLoggerI.sendTraceQid(_currAgent->id.id, TOS_NODE_ID, QUERY_GET_LOCATION_RESULTS_RECEIVED, ((TOS_NODE_ID & 0xff) << 8) | (_qid-1), FAIL, loc);
	#endif

	#if DEBUG_OP_GETLOCATION
		dbg("DBG_USR1", "OPgetlocationM: ERROR: Timed out while waiting for results.\n");
	#endif

	finish(FAIL);

	}

	/**
	 * Bounces a message off this mote.
	 */
	event message_t* ReceiveRequest.receive(message_t* m, void *payload, uint8_t len)
	{
	message_t* msg = call MessageBufferI.getMsg();
	if (msg != NULL)
	{
		*msg = *m;
		if (sendQueryMsg(msg) != SUCCESS)
		call MessageBufferI.freeMsg(msg);
		else 
		{
		#if ENABLE_EXP_LOGGING
			//struct AgillaQueryAgentLocMsg *qMsg = (struct AgillaQueryAgentLocMsg *)msg->data; 
			AgillaQueryAgentLocMsg *qMsg = (AgillaQueryAgentLocMsg *)payload;
			AgillaLocation loc;
			call LocationMgrI.getLocation(qMsg->dest, &loc);
			call ExpLoggerI.sendTraceQid(qMsg->agent_id.id, TOS_NODE_ID, QUERY_GET_LOCATION_FORWARDED, qMsg->qid, SUCCESS, loc);
		#endif
		}
	}
	return m;
	}

	//RECEIVE SERIAL
	event message_t* SerialReceiveRequest.receive(message_t* m, void *payload, uint8_t len)
	{
	message_t* msg = call MessageBufferI.getMsg();
	if (msg != NULL)
	{
		*msg = *m;
		if (sendQueryMsg(msg) != SUCCESS)
		call MessageBufferI.freeMsg(msg);
		else 
		{
		#if ENABLE_EXP_LOGGING
			//struct AgillaQueryAgentLocMsg *qMsg = (struct AgillaQueryAgentLocMsg *)msg->data; 
			AgillaQueryAgentLocMsg *qMsg = (AgillaQueryAgentLocMsg *)payload;
			AgillaLocation loc;
			call LocationMgrI.getLocation(qMsg->dest, &loc);
			call ExpLoggerI.sendTraceQid(qMsg->agent_id.id, TOS_NODE_ID, QUERY_GET_LOCATION_FORWARDED, qMsg->qid, SUCCESS, loc);
		#endif
		}
	}
	return m;
	}

	event void SendRequest.sendDone(message_t* m, error_t success)
	{
	call MessageBufferI.freeMsg(m);

	}

	event void SendResults.sendDone(message_t* m, error_t success)
	{
	call MessageBufferI.freeMsg(m);

	}
	
	event void SerialSendRequest.sendDone(message_t* m, error_t success)
	{
	call MessageBufferI.freeMsg(m);

	}

	event void SerialSendResults.sendDone(message_t* m, error_t success)
	{
	call MessageBufferI.freeMsg(m);

	}

}
