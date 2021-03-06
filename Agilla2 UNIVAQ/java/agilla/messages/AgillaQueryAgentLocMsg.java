/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'AgillaQueryAgentLocMsg'
 * message type.
 */

package agilla.messages;

public class AgillaQueryAgentLocMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 12;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 68;

    /** Create a new AgillaQueryAgentLocMsg of size 12. */
    public AgillaQueryAgentLocMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new AgillaQueryAgentLocMsg of the given data_length. */
    public AgillaQueryAgentLocMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaQueryAgentLocMsg with the given data_length
     * and base offset.
     */
    public AgillaQueryAgentLocMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaQueryAgentLocMsg using the given byte array
     * as backing store.
     */
    public AgillaQueryAgentLocMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaQueryAgentLocMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public AgillaQueryAgentLocMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaQueryAgentLocMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public AgillaQueryAgentLocMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaQueryAgentLocMsg embedded in the given message
     * at the given base offset.
     */
    public AgillaQueryAgentLocMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaQueryAgentLocMsg embedded in the given message
     * at the given base offset and length.
     */
    public AgillaQueryAgentLocMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <AgillaQueryAgentLocMsg> \n";
      try {
        s += "  [agent_id.id=0x"+Long.toHexString(get_agent_id_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [src=0x"+Long.toHexString(get_src())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [dest=0x"+Long.toHexString(get_dest())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [qid=0x"+Long.toHexString(get_qid())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [flags=0x"+Long.toHexString(get_flags())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [find_agent_id.id=0x"+Long.toHexString(get_find_agent_id_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: agent_id.id
    //   Field type: int
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'agent_id.id' is signed (false).
     */
    public static boolean isSigned_agent_id_id() {
        return false;
    }

    /**
     * Return whether the field 'agent_id.id' is an array (false).
     */
    public static boolean isArray_agent_id_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'agent_id.id'
     */
    public static int offset_agent_id_id() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'agent_id.id'
     */
    public static int offsetBits_agent_id_id() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'agent_id.id'
     */
    public int get_agent_id_id() {
        return (int)getUIntBEElement(offsetBits_agent_id_id(), 16);
    }

    /**
     * Set the value of the field 'agent_id.id'
     */
    public void set_agent_id_id(int value) {
        setUIntBEElement(offsetBits_agent_id_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'agent_id.id'
     */
    public static int size_agent_id_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'agent_id.id'
     */
    public static int sizeBits_agent_id_id() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: src
    //   Field type: int
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'src' is signed (false).
     */
    public static boolean isSigned_src() {
        return false;
    }

    /**
     * Return whether the field 'src' is an array (false).
     */
    public static boolean isArray_src() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'src'
     */
    public static int offset_src() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'src'
     */
    public static int offsetBits_src() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'src'
     */
    public int get_src() {
        return (int)getUIntBEElement(offsetBits_src(), 16);
    }

    /**
     * Set the value of the field 'src'
     */
    public void set_src(int value) {
        setUIntBEElement(offsetBits_src(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'src'
     */
    public static int size_src() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'src'
     */
    public static int sizeBits_src() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: dest
    //   Field type: int
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'dest' is signed (false).
     */
    public static boolean isSigned_dest() {
        return false;
    }

    /**
     * Return whether the field 'dest' is an array (false).
     */
    public static boolean isArray_dest() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'dest'
     */
    public static int offset_dest() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'dest'
     */
    public static int offsetBits_dest() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'dest'
     */
    public int get_dest() {
        return (int)getUIntBEElement(offsetBits_dest(), 16);
    }

    /**
     * Set the value of the field 'dest'
     */
    public void set_dest(int value) {
        setUIntBEElement(offsetBits_dest(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'dest'
     */
    public static int size_dest() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'dest'
     */
    public static int sizeBits_dest() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: qid
    //   Field type: int
    //   Offset (bits): 48
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'qid' is signed (false).
     */
    public static boolean isSigned_qid() {
        return false;
    }

    /**
     * Return whether the field 'qid' is an array (false).
     */
    public static boolean isArray_qid() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'qid'
     */
    public static int offset_qid() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'qid'
     */
    public static int offsetBits_qid() {
        return 48;
    }

    /**
     * Return the value (as a int) of the field 'qid'
     */
    public int get_qid() {
        return (int)getUIntBEElement(offsetBits_qid(), 16);
    }

    /**
     * Set the value of the field 'qid'
     */
    public void set_qid(int value) {
        setUIntBEElement(offsetBits_qid(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'qid'
     */
    public static int size_qid() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'qid'
     */
    public static int sizeBits_qid() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: flags
    //   Field type: int
    //   Offset (bits): 64
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'flags' is signed (false).
     */
    public static boolean isSigned_flags() {
        return false;
    }

    /**
     * Return whether the field 'flags' is an array (false).
     */
    public static boolean isArray_flags() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'flags'
     */
    public static int offset_flags() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'flags'
     */
    public static int offsetBits_flags() {
        return 64;
    }

    /**
     * Return the value (as a int) of the field 'flags'
     */
    public int get_flags() {
        return (int)getUIntBEElement(offsetBits_flags(), 16);
    }

    /**
     * Set the value of the field 'flags'
     */
    public void set_flags(int value) {
        setUIntBEElement(offsetBits_flags(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'flags'
     */
    public static int size_flags() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'flags'
     */
    public static int sizeBits_flags() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: find_agent_id.id
    //   Field type: int
    //   Offset (bits): 80
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'find_agent_id.id' is signed (false).
     */
    public static boolean isSigned_find_agent_id_id() {
        return false;
    }

    /**
     * Return whether the field 'find_agent_id.id' is an array (false).
     */
    public static boolean isArray_find_agent_id_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'find_agent_id.id'
     */
    public static int offset_find_agent_id_id() {
        return (80 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'find_agent_id.id'
     */
    public static int offsetBits_find_agent_id_id() {
        return 80;
    }

    /**
     * Return the value (as a int) of the field 'find_agent_id.id'
     */
    public int get_find_agent_id_id() {
        return (int)getUIntBEElement(offsetBits_find_agent_id_id(), 16);
    }

    /**
     * Set the value of the field 'find_agent_id.id'
     */
    public void set_find_agent_id_id(int value) {
        setUIntBEElement(offsetBits_find_agent_id_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'find_agent_id.id'
     */
    public static int size_find_agent_id_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'find_agent_id.id'
     */
    public static int sizeBits_find_agent_id_id() {
        return 16;
    }

}
