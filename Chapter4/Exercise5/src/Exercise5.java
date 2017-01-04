/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/09/2016.
 */

import java.util.Scanner;

public class Exercise5
{
    public static void main(String[] args) {
        // First create a Scanner object for the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        String userString;          // To hold the string entered by the user
        String input;               // String used to temporarily hold input
        char userCharacter;         // To hold the character entered by the user
        int total = 0;              // To hold the total number of times the character appears
        int strLen;                 // To hold the length of the lines of text read from the file

        // Get the user to enter a string
        System.out.print("Enter some text: ");
        userString = keyboard.nextLine();

        // Get the user to enter the character to count
        System.out.print("Enter the character to count in the text: ");
        input = keyboard.next();
        userCharacter = input.charAt(0);

        // Read through the line and count the number of times that the users character appears
        strLen = userString.length();
        for(int i=0; i<strLen; i++)
        {
            if(userString.charAt(i)==userCharacter)
                total++;
        }

        // Print out the result
        System.out.println("The character '" + userCharacter + "' appears " +
                            total + " times in your text");

    }
}
