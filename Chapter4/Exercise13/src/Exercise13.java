/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   08/09/2016.
 */

import java.util.Scanner;
import java.io.*;

public class Exercise13
{
    public static void main(String[] args) throws IOException
    {
        // Create a Scanner object for the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        String filename;
        String line;

        int linesToRead = 5;

        // Get the user to enter a filename
        System.out.print("Enter the name of the file: ");
        filename = keyboard.next();

        FileReader freader = new FileReader(filename);
        BufferedReader inputFile = new BufferedReader(freader);

        line = inputFile.readLine();

        while(line!=null && linesToRead>0)
        {
            System.out.println(line);
            linesToRead--;
            line = inputFile.readLine();
        }

        // Close the connection to the file
        inputFile.close();
    }
}
