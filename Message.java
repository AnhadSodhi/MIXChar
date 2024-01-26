package q3;

/**
 * Represents a message made up of MIXChar objects.
 * 
 * @author Anhad Sodhi (Set 1B)
 * @version 1.0
 */
public class Message {
    
    /** 
     * The maximum number of MIXChar characters that can be packed in a
     * long. 
     */
    private static final int MAX_PACKED = 11;
    
    /** The BASE used when packing the MIXChars objects. */
    private static final int BASE = 56;
    
    /** Each long in the list is a packed form of MIXChar objects. */
    private long[] list;
    
    /** The current number of MIXChar characters packed in the list. */
    private int charCount;
    
    /**
     * Constructs a Message object by passing the parameter's MIXChar array to
     * processArray().
     * @param m as a MIXChar array.
     */
    public Message(MIXChar[] m) {
        processArray(m);
    }
    
    /**
     * Constructs a Message object by converting the parameter's String to a
     * MIXChar array, then passing that to processArray().
     * @param s as a String
     */
    public Message(String s) {
        MIXChar[] m = new MIXChar[s.length()];
        for (int i = 0; i < m.length; i++) {
            m[i] = new MIXChar(s.charAt(i));
        }
        processArray(m);
    }
    
    /**
     * Packs the MIXChar array passed as a parameter into the list. Is
     * converted into a BASE 56 number, then added to the list. Each long holds
     * 11 MIXChars.
     * @param m as a MIXChar array
     */
    private void processArray(MIXChar[] m) {
        if (m.length % MAX_PACKED == 0) {
            list = new long[(m.length / MAX_PACKED)];
        } else {
            list = new long[(m.length / MAX_PACKED) + 1];
        }
        
        for (int j = 0; j < list.length; j++) {
            
            for (int i = 0; i < MAX_PACKED && charCount < m.length; i++) {
                MIXChar temp = m[charCount];
                
                long ordinal = temp.ordinal();
                ordinal *= (long) Math.pow(BASE, i);
                
                list[j] += ordinal;
                charCount++;
            }
        }
    }
    
    /**
     * Returns a String representation of the Message object. Loops through
     * each long in the list, unpacks all the MIXChars, and adds them to the
     * return String.
     * @return formatted representation as a String
     */
    public String toString() {
        String str = "";
        
        for (int i = 0; i < list.length; i++) {
            long quotient = list[i];
            while (quotient != 0) {
                long ordinal = Long.remainderUnsigned(quotient, BASE);
                char temp = MIXChar.ALLCHARS[(int) ordinal];

                str += new MIXChar(temp);
                quotient = Long.divideUnsigned(quotient, BASE);
            }
        }
        return str;
    }
    
    /**
     * Returns a String containing all the longs in list, each seperated by a
     * space.
     * @return formatted representation as a String
     */
    public String toLongs() {
        String str = "";
        
        for (int i = 0; i < list.length; i++) {
            str += Long.toUnsignedString(list[i]);
            str += " ";
        }
        
        return str;
    }
    
}
