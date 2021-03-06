/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'AgillaAckCodeMsg'
 * message type.
 */

package agilla.messages;

public class AgillaAckCodeMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 6;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 22;

    /** Create a new AgillaAckCodeMsg of size 6. */
    public AgillaAckCodeMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new AgillaAckCodeMsg of the given data_length. */
    public AgillaAckCodeMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaAckCodeMsg with the given data_length
     * and base offset.
     */
    public AgillaAckCodeMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaAckCodeMsg using the given byte array
     * as backing store.
     */
    public AgillaAckCodeMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaAckCodeMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public AgillaAckCodeMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaAckCodeMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public AgillaAckCodeMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaAckCodeMsg embedded in the given message
     * at the given base offset.
     */
    public AgillaAckCodeMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new AgillaAckCodeMsg embedded in the given message
     * at the given base offset and length.
     */
    public AgillaAckCodeMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <AgillaAckCodeMsg> \n";
      try {
        s += "  [id.id=0x"+Long.toHexString(get_id_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [accept=0x"+Long.toHexString(get_accept())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [msgNum=0x"+Long.toHexString(get_msgNum())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: id.id
    //   Field type: int, unsigned
    //   Offset (bits): 0
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
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'id.id'
     */
    public static int offsetBits_id_id() {
        return 0;
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
    // Accessor methods for field: accept
    //   Field type: int, unsigned
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'accept' is signed (false).
     */
    public static boolean isSigned_accept() {
        return false;
    }

    /**
     * Return whether the field 'accept' is an array (false).
     */
    public static boolean isArray_accept() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'accept'
     */
    public static int offset_accept() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'accept'
     */
    public static int offsetBits_accept() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'accept'
     */
    public int get_accept() {
        return (int)getUIntBEElement(offsetBits_accept(), 16);
    }

    /**
     * Set the value of the field 'accept'
     */
    public void set_accept(int value) {
        setUIntBEElement(offsetBits_accept(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'accept'
     */
    public static int size_accept() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'accept'
     */
    public static int sizeBits_accept() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: msgNum
    //   Field type: int, unsigned
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'msgNum' is signed (false).
     */
    public static boolean isSigned_msgNum() {
        return false;
    }

    /**
     * Return whether the field 'msgNum' is an array (false).
     */
    public static boolean isArray_msgNum() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'msgNum'
     */
    public static int offset_msgNum() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'msgNum'
     */
    public static int offsetBits_msgNum() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'msgNum'
     */
    public int get_msgNum() {
        return (int)getUIntBEElement(offsetBits_msgNum(), 16);
    }

    /**
     * Set the value of the field 'msgNum'
     */
    public void set_msgNum(int value) {
        setUIntBEElement(offsetBits_msgNum(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'msgNum'
     */
    public static int size_msgNum() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'msgNum'
     */
    public static int sizeBits_msgNum() {
        return 16;
    }

}
