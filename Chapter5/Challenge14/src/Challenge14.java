/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/09/2016.
 */

import javax.swing.JOptionPane;     // needed for the input/output dialogues
import java.io.*;                   // needed for FileWrite PrintWriter

public class Challenge14
{
    public static void main(String[] args) throws IOException
    {
        String filename;       // to hold the user's input

        // Get the name of the output file from the user and open
        //  it for writing the primes to
        filename = JOptionPane.showInputDialog("Enter the name of the output file");
        FileWriter fwriter = new FileWriter(filename);
        PrintWriter outputFile = new PrintWriter(fwriter);

        // Write the prime numbers between 1 through 100 to the output file
        for(int testNumber=1; testNumber<=100; testNumber++)
        {
            //If the number is prime write it to the output file
            if( isPrime( testNumber ) )
                outputFile.println(testNumber);
        }

        // Close the output file
        outputFile.close();

        JOptionPane.showMessageDialog(null, "The primes have been written to " + filename);

        // Close the thread created by the message dialogue
        System.exit(0);
    }


    /**
     * The method isPrime tests whether the number passed to it
     * is a prime number
     * @param testNumber The number that is being tested whether it is prime or not
     * @return Whether the number is a prime or not as a boolean
     */
    public static boolean isPrime(int testNumber)
    {
        // A prime number cannot be divided by a number greater than
        // its square root so this is used for optimising
        int max = (int)Math.ceil(Math.sqrt(testNumber));

        if(testNumber<1) return false;     // negative numbers can not be prime
        if(testNumber<4) return true;      // 1,2 and 3 are primes
        if(testNumber%2==0) return false;  // all even numbers > 2 are not primes

        // All even numbers have been eliminated in the previous statement
        for(int i=3; i<=max; i+=2)
        {
            if(testNumber%i==0)
                return false;
        }

        return true;
    }

}
