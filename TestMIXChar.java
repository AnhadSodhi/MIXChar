package q3;

import java.util.Scanner;

/**
 * A driver class for the Message class.
 * It requests a String from the user, and processes it using the Message class.
 *
 * @author Anhad Sodhi (Set 1B)
 * @version 1.0
 */
public class TestMIXChar {
    
    /**
     * This is the main method (entry point) that gets called by the JVM.
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //request input
        System.out.println("Enter a string of MIX characters");
        String input = scan.nextLine();
        
        try {
            //create a Message using the input
            MIXChar[] charList = MIXChar.toMIXChar(input);
            Message msg = new Message(charList);
            
            //print the long representation of the Message
            System.out.println("toLongs:");
            System.out.println(msg.toLongs());
            System.out.println();
            
            //print the String representation of the Message
            System.out.println("toString:");
            System.out.println(msg.toString());
            
        } catch (IllegalArgumentException e) {
            //throw an error if any of the input characters is not a valid
            //MIXChar character
            System.out.println("Error! one of the characters is not valid.");
        }
        
        scan.close();
    }
    
}
