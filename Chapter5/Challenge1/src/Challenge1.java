/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/09/2016.
 */

import javax.swing.JOptionPane;     // needed for the input/output dialogues

public class Challenge1
{
    public static void main(String[] args)
    {
        String input;           // to temporarily hold the user's input whilst it is validated
        String userString;      // to hold the user's string
        int charIndex;          // to hold the entered character index

        // Get the user to input the string to pass to showChar
        input = JOptionPane.showInputDialog("Enter your string: ");

        while(input.length()==0)
        {
            input = JOptionPane.showInputDialog("ERROR - string cannot be left empty\nEnter your string: ");
        }

        userString = input;

        // Get the user to input the index to pass to showChar
        input = JOptionPane.showInputDialog("Enter the character index: ");
        charIndex = Integer.parseInt(input);

        while(charIndex > userString.length())
        {
            input = JOptionPane.showInputDialog("ERROR - Index cannot be greater than or equal to\n" +
                                                "the length of the string\nEnter the character index: ");
            charIndex = Integer.parseInt(input);
        }

        // Pass the user's input to showChar
        showChar(userString, charIndex);

        //Close the thread created by the message dialogue in showChar
        System.exit(0);
    }


    /**
     * The method showChar display the character in the string at the index position
     * specified.
     * @param userString A string entered by the user
     * @param charIndex An index entered by the user
     */
    public static void showChar(String userString, int charIndex )
    {
        JOptionPane.showMessageDialog(null,userString.charAt(charIndex));
    }
}
