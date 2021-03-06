// $Id: LEDBlinkerM.nc,v 1.3 2006/02/11 08:12:31 chien-liang Exp $

/* LED Blinker - A utility for blinking the LEDs in various
 * patterns.
 * Copyright (C) 2005, Washington University in Saint Louis 
 * By Chien-Liang Fok.
 * 
 * Washington University states that LED Blinker is free software; 
 * you can redistribute it and/or modify it under the terms of 
 * the current version of the GNU Lesser General Public License 
 * as published by the Free Software Foundation.
 * 
 * LED Blinker is distributed in the hope that it will be useful, but 
 * THERE ARE NO WARRANTIES, WHETHER ORAL OR WRITTEN, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO, IMPLIED WARRANTIES OF 
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR USE.
 *
 * YOU UNDERSTAND THAT AGILLA IS PROVIDED "AS IS" FOR WHICH NO 
 * WARRANTIES AS TO CAPABILITIES OR ACCURACY ARE MADE. THERE ARE NO 
 * WARRANTIES AND NO REPRESENTATION THAT AGILLA IS FREE OF 
 * INFRINGEMENT OF THIRD PARTY PATENT, COPYRIGHT, OR OTHER 
 * PROPRIETARY RIGHTS.  THERE ARE NO WARRANTIES THAT SOFTWARE IS 
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
 includes LEDBlinker;
#include "Timer.h"

module LEDBlinkerM 
{
  provides 
  {
    interface LEDBlinkerI;
    interface Init;
  }
  uses 
  {
    interface Leds;
    interface Timer<TMilli> as Timer0;
  }
}
implementation {
  bool blinking;
  uint16_t _whichLEDs, _count, _curr, _period;
  
  command error_t Init.init() {
    blinking = FALSE;
    return SUCCESS;
  }

  void setLEDs(uint16_t whichLEDs) {
    if (whichLEDs & 1) call Leds.led0Toggle();
    if (whichLEDs & 2) call Leds.led1Toggle();
    if (whichLEDs & 4) call Leds.led2Toggle();  
  }

  /**
   * Blinks the LEDs.
   *
   * Which LEDs to blink is specified by an 8-bit value.  The lowest five bits 
   * determine how to actuate the LEDs. The lowest three bits denote the 3 LEDs; 
   * bit 0 is red, bit 1 is green, and bit 2 is yellow. If a bit is set, the 
   * corresponding LED will be toggled.
   * 
   * Here is a summary of the possible combination of bits
   *    Toggle Operation     Binary Value   Decimal Value
   *    red                  00000001       1
   *    green                00000010       2
   *    yellow               00000100       4
   *    red & green          00000011       3
   *    red & yellow         00000101       5
   *    green & yellow       00000110       6
   *    all 3 LEDs           00000111       7
   *
   * @param whichLEDs Which LEDs to blink, encoded as described above.
   * @param count The number of times to blink.
   * @param period The period in binary milliseconds.  A period is the time the
   * LED is on or off (not both).
   */
  command error_t LEDBlinkerI.blink(uint16_t whichLEDs, uint16_t count, uint16_t period) 
  {
    if (!blinking) 
    {
      blinking = TRUE;
      _whichLEDs = whichLEDs;
      _count = count*2;
      _period = period;
      setLEDs(_whichLEDs);
      _curr = 1;      
      call Timer0.startOneShot(_period);
      return SUCCESS;
    } else
      return FAIL;
  }
  
  event void Timer0.fired() 
  {
    setLEDs(_whichLEDs);
    if (++_curr == _count) 
    {      
      blinking = FALSE;
      signal LEDBlinkerI.blinkDone();
    } else
      call Timer0.startOneShot(_period);
  }
  
  /**
   * Signalled when the blinking is done and blink(...) can be called again.
   */
  default event error_t LEDBlinkerI.blinkDone() {  
    return SUCCESS;
  }
}
