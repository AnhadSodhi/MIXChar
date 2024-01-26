package q3;

/**
 * Represents a MIXChar character.
 *
 * @author Anhad Sodhi (Set 1B)
 * @version 1.0
 */
public class MIXChar {
    
    /** A char array of all the characters in the MIXChar alphabet. */
    public static final char[] ALLCHARS = {' ', 'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', '\u0394', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', '\u03A3', '\u03A0', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '.', ',', '(', ')', '+', '-', '*', '/', '=', '$', '<', '>',
        '@', ';', ':', '\'' };
    
    /** The unicode value of the MIXChar character. */
    private final int mixInt;
    
    /**
     * Constructs a MIXchar object that sets the mixInt to the char parameter.
     * @param c as a char
     * @throws IllegalArgumentException if the character is not in the MIXChar
     *     alphabet.
     */
    public MIXChar(char c) throws IllegalArgumentException {
        if (isMIXChar(c)) {
            mixInt = c;
        } else {
            throw new IllegalArgumentException(
                    "That character is not a MIXChar.");
        }
    }
    
    /**
     * Checks if a char is in the MIXChar alphabet.
     * @param c as a char
     * @return is it in? as a boolean
     */
    public static boolean isMIXChar(char c) {
        boolean isChar = false;
        
        for (int i = 0; i < ALLCHARS.length; i++) {
            if (c == ALLCHARS[i]) {
                isChar = true;
            }
        }
        
        return isChar;
    }
    
    /**
     * Returns the unicode char that this MIXChar object represents.
     * @return mixInt as a char
     */
    public char toChar() {
        return (char) mixInt;
    }
    
    /**
     * Returns a String representation of the MIXChar array passed as a
     * parameter.
     * @param list as a MIXChar array
     * @return formatted representation as a String
     */
    public static String toString(MIXChar[] list) {
        String str = "";
        
        for (int i = 0; i < list.length; i++) {
            str += list[i].toChar();
        }
        
        return str;
    }
    
    /**
     * Converts a String to a MIXChar array.
     * @param s as a String
     * @return list as a MIXChar array
     */
    public static MIXChar[] toMIXChar(String s) {
        MIXChar[] list = new MIXChar[s.length()];
        
        for (int i = 0; i < list.length; i++) {
            list[i] = new MIXChar(s.charAt(i));
        }
        
        return list;
    }
    
    /**
     * Returns the matching ALLCHARS array index of the java character this
     * MIXChar object represents.
     * @return index as an int
     */
    public int ordinal() {
        int index = -1;
        
        for (int i = 0; i < ALLCHARS.length; i++) {
            if ((char) mixInt == ALLCHARS[i]) {
                index = i;
            }
        }
        return index;
    }
    
    /**
     * Returns a String representation of the MIXChar object.
     * @return formatted representation as a String
     */
    public String toString() {
        return "" + toChar();
    }
}
