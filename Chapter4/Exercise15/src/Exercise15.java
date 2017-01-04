/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   08/09/2016.
 */

import java.util.Scanner;
import java.io.*;

public class Exercise15
{
    public static void main(String[] args) throws IOException
    {
        // Create a Scanner object for the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        String inputFilename, outputFilename;
        String line;

        // Get the user to enter an input filename
        System.out.print("Enter the name of the input file: ");
        inputFilename = keyboard.next();

        // Get the user to enter an output filename
        System.out.print("Enter the name of the output file: ");
        outputFilename = keyboard.next();

        // Open the inputfile
        FileReader freader = new FileReader(inputFilename);
        BufferedReader inputFile = new BufferedReader(freader);

        // Create and open the output file for reading
        FileWriter fwriter = new FileWriter(outputFilename);
        PrintWriter outputFile = new PrintWriter(fwriter);

        line = inputFile.readLine();

        while(line!=null)
        {
            line = line.toUpperCase();
            outputFile.println(line);
            line = inputFile.readLine();
        }

        // Close the connections to the files
        inputFile.close();
        outputFile.close();
    }
}