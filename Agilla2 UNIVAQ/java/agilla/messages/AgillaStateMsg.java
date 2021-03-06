/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'AgillaStateMsg'
 * message type.
 */

package agilla.messages;

public class AgillaStateMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 18;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 16;

    /** Create a new AgillaStateMsg of size 18. */
    public AgillaStateMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new AgillaStateMsg of the given data_length. */
    public AgillaStateMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaStateMsg with the given data_length
     * and base offset.
     */
    public AgillaStateMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaStateMsg using the given byte array
     * as backing store.
     */
    public AgillaStateMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaStateMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public AgillaStateMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaStateMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public AgillaStateMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaStateMsg embedded in the given message
     * at the given base offset.
     */
    public AgillaStateMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaStateMsg embedded in the given message
     * at the given base offset and length.
     */
    public AgillaStateMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <AgillaStateMsg> \n";
      try {
        s += "  [replyAddr=0x"+Long.toHexString(get_replyAddr())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [id.id=0x"+Long.toHexString(get_id_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [dest=0x"+Long.toHexString(get_dest())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [op=0x"+Long.toHexString(get_op())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [sp=0x"+Long.toHexString(get_sp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [pc=0x"+Long.toHexString(get_pc())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [condition=0x"+Long.toHexString(get_condition())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [codeSize=0x"+Long.toHexString(get_codeSize())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [numHpMsgs=0x"+Long.toHexString(get_numHpMsgs())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [numRxnMsgs=0x"+Long.toHexString(get_numRxnMsgs())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [desc.value=0x"+Long.toHexString(get_desc_value())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: replyAddr
    //   Field type: int
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'replyAddr' is signed (false).
     */
    public static boolean isSigned_replyAddr() {
        return false;
    }

    /**
     * Return whether the field 'replyAddr' is an array (false).
     */
    public static boolean isArray_replyAddr() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'replyAddr'
     */
    public static int offset_replyAddr() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'replyAddr'
     */
    public static int offsetBits_replyAddr() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'replyAddr'
     */
    public int get_replyAddr() {
        return (int)getUIntBEElement(offsetBits_replyAddr(), 16);
    }

    /**
     * Set the value of the field 'replyAddr'
     */
    public void set_replyAddr(int value) {
        setUIntBEElement(offsetBits_replyAddr(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'replyAddr'
     */
    public static int size_replyAddr() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'replyAddr'
     */
    public static int sizeBits_replyAddr() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: id.id
    //   Field type: int
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'id.id' is signed (false).
     */
    public static boolean isSigned_id_id() {
        return false;
    }

    /**
     * Return whether the field 'id.id' is an array (false).
     */
    public static boolean isArray_id_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'id.id'
     */
    public static int offset_id_id() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'id.id'
     */
    public static int offsetBits_id_id() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'id.id'
     */
    public int get_id_id() {
        return (int)getUIntBEElement(offsetBits_id_id(), 16);
    }

    /**
     * Set the value of the field 'id.id'
     */
    public void set_id_id(int value) {
        setUIntBEElement(offsetBits_id_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'id.id'
     */
    public static int size_id_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'id.id'
     */
    public static int sizeBits_id_id() {
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
    // Accessor methods for field: op
    //   Field type: short
    //   Offset (bits): 48
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'op' is signed (false).
     */
    public static boolean isSigned_op() {
        return false;
    }

    /**
     * Return whether the field 'op' is an array (false).
     */
    public static boolean isArray_op() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'op'
     */
    public static int offset_op() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'op'
     */
    public static int offsetBits_op() {
        return 48;
    }

    /**
     * Return the value (as a short) of the field 'op'
     */
    public short get_op() {
        return (short)getUIntBEElement(offsetBits_op(), 8);
    }

    /**
     * Set the value of the field 'op'
     */
    public void set_op(short value) {
        setUIntBEElement(offsetBits_op(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'op'
     */
    public static int size_op() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'op'
     */
    public static int sizeBits_op() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: sp
    //   Field type: short
    //   Offset (bits): 56
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'sp' is signed (false).
     */
    public static boolean isSigned_sp() {
        return false;
    }

    /**
     * Return whether the field 'sp' is an array (false).
     */
    public static boolean isArray_sp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'sp'
     */
    public static int offset_sp() {
        return (56 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'sp'
     */
    public static int offsetBits_sp() {
        return 56;
    }

    /**
     * Return the value (as a short) of the field 'sp'
     */
    public short get_sp() {
        return (short)getUIntBEElement(offsetBits_sp(), 8);
    }

    /**
     * Set the value of the field 'sp'
     */
    public void set_sp(short value) {
        setUIntBEElement(offsetBits_sp(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'sp'
     */
    public static int size_sp() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'sp'
     */
    public static int sizeBits_sp() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: pc
    //   Field type: int
    //   Offset (bits): 64
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'pc' is signed (false).
     */
    public static boolean isSigned_pc() {
        return false;
    }

    /**
     * Return whether the field 'pc' is an array (false).
     */
    public static boolean isArray_pc() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'pc'
     */
    public static int offset_pc() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'pc'
     */
    public static int offsetBits_pc() {
        return 64;
    }

    /**
     * Return the value (as a int) of the field 'pc'
     */
    public int get_pc() {
        return (int)getUIntBEElement(offsetBits_pc(), 16);
    }

    /**
     * Set the value of the field 'pc'
     */
    public void set_pc(int value) {
        setUIntBEElement(offsetBits_pc(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'pc'
     */
    public static int size_pc() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'pc'
     */
    public static int sizeBits_pc() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: condition
    //   Field type: int
    //   Offset (bits): 80
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'condition' is signed (false).
     */
    public static boolean isSigned_condition() {
        return false;
    }

    /**
     * Return whether the field 'condition' is an array (false).
     */
    public static boolean isArray_condition() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'condition'
     */
    public static int offset_condition() {
        return (80 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'condition'
     */
    public static int offsetBits_condition() {
        return 80;
    }

    /**
     * Return the value (as a int) of the field 'condition'
     */
    public int get_condition() {
        return (int)getUIntBEElement(offsetBits_condition(), 16);
    }

    /**
     * Set the value of the field 'condition'
     */
    public void set_condition(int value) {
        setUIntBEElement(offsetBits_condition(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'condition'
     */
    public static int size_condition() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'condition'
     */
    public static int sizeBits_condition() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: codeSize
    //   Field type: int
    //   Offset (bits): 96
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'codeSize' is signed (false).
     */
    public static boolean isSigned_codeSize() {
        return false;
    }

    /**
     * Return whether the field 'codeSize' is an array (false).
     */
    public static boolean isArray_codeSize() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'codeSize'
     */
    public static int offset_codeSize() {
        return (96 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'codeSize'
     */
    public static int offsetBits_codeSize() {
        return 96;
    }

    /**
     * Return the value (as a int) of the field 'codeSize'
     */
    public int get_codeSize() {
        return (int)getUIntBEElement(offsetBits_codeSize(), 16);
    }

    /**
     * Set the value of the field 'codeSize'
     */
    public void set_codeSize(int value) {
        setUIntBEElement(offsetBits_codeSize(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'codeSize'
     */
    public static int size_codeSize() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'codeSize'
     */
    public static int sizeBits_codeSize() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: numHpMsgs
    //   Field type: short
    //   Offset (bits): 112
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'numHpMsgs' is signed (false).
     */
    public static boolean isSigned_numHpMsgs() {
        return false;
    }

    /**
     * Return whether the field 'numHpMsgs' is an array (false).
     */
    public static boolean isArray_numHpMsgs() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'numHpMsgs'
     */
    public static int offset_numHpMsgs() {
        return (112 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'numHpMsgs'
     */
    public static int offsetBits_numHpMsgs() {
        return 112;
    }

    /**
     * Return the value (as a short) of the field 'numHpMsgs'
     */
    public short get_numHpMsgs() {
        return (short)getUIntBEElement(offsetBits_numHpMsgs(), 8);
    }

    /**
     * Set the value of the field 'numHpMsgs'
     */
    public void set_numHpMsgs(short value) {
        setUIntBEElement(offsetBits_numHpMsgs(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'numHpMsgs'
     */
    public static int size_numHpMsgs() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'numHpMsgs'
     */
    public static int sizeBits_numHpMsgs() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: numRxnMsgs
    //   Field type: short
    //   Offset (bits): 120
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'numRxnMsgs' is signed (false).
     */
    public static boolean isSigned_numRxnMsgs() {
        return false;
    }

    /**
     * Return whether the field 'numRxnMsgs' is an array (false).
     */
    public static boolean isArray_numRxnMsgs() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'numRxnMsgs'
     */
    public static int offset_numRxnMsgs() {
        return (120 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'numRxnMsgs'
     */
    public static int offsetBits_numRxnMsgs() {
        return 120;
    }

    /**
     * Return the value (as a short) of the field 'numRxnMsgs'
     */
    public short get_numRxnMsgs() {
        return (short)getUIntBEElement(offsetBits_numRxnMsgs(), 8);
    }

    /**
     * Set the value of the field 'numRxnMsgs'
     */
    public void set_numRxnMsgs(short value) {
        setUIntBEElement(offsetBits_numRxnMsgs(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'numRxnMsgs'
     */
    public static int size_numRxnMsgs() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'numRxnMsgs'
     */
    public static int sizeBits_numRxnMsgs() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: desc.value
    //   Field type: short
    //   Offset (bits): 128
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'desc.value' is signed (false).
     */
    public static boolean isSigned_desc_value() {
        return false;
    }

    /**
     * Return whether the field 'desc.value' is an array (false).
     */
    public static boolean isArray_desc_value() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'desc.value'
     */
    public static int offset_desc_value() {
        return (128 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'desc.value'
     */
    public static int offsetBits_desc_value() {
        return 128;
    }

    /**
     * Return the value (as a short) of the field 'desc.value'
     */
    public short get_desc_value() {
        return (short)getSIntBEElement(offsetBits_desc_value(), 16);
    }

    /**
     * Set the value of the field 'desc.value'
     */
    public void set_desc_value(short value) {
        setSIntBEElement(offsetBits_desc_value(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'desc.value'
     */
    public static int size_desc_value() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'desc.value'
     */
    public static int sizeBits_desc_value() {
        return 16;
    }

}
