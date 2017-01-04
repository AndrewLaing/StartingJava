/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/09/2016.
 */
import java.util.Scanner;
import java.io.*;

public class Exercise6
{
    public static void main(String[] args) throws IOException {
        // First create a Scanner object for the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        String filename;            // To hold the filename entered by the user
        String input;               // String used to temporarily hold input
        char userCharacter;         // To hold the character entered by the user
        int total = 0;              // To hold the total number of times the character appears
        int strLen;                 // To hold the length of the lines of text read from the file

        // Get the user to enter the filename
        System.out.print("Enter the filename: ");
        filename = keyboard.next();

        // Get the user to enter the character to count
        System.out.print("Enter the character to count: ");
        input = keyboard.next();
        userCharacter = input.charAt(0);

        // Create a FileReader and BufferedReader object to read the file
        FileReader freader = new FileReader(filename);
        BufferedReader inputFile = new BufferedReader(freader);

        // Read through the file one line at a time
        input = inputFile.readLine();

        while(input!=null)
        {
            // Read through the line and count the number of times that the users character appears
            strLen = input.length();
            for(int i=0; i<strLen; i++)
            {
                if(input.charAt(i)==userCharacter)
                    total++;
            }

            // Read in another line from the file
            input = inputFile.readLine();
        }

        // Close the connection to the file
        inputFile.close();

        // Print out the result
        System.out.println("The character '" + userCharacter + "' appears " +
                total + " times in '" + filename + "'.");

    }
}