/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/09/2016.
 */

import javax.swing.JOptionPane; // needed for the input/output dialogues

public class Challenge13
{
    public static void main(String[] args)
    {
        int testNumber;     // to hold the user's number
        String input;       // to hold the user's input

        input = JOptionPane.showInputDialog("Enter the number to test");
        testNumber = Integer.parseInt(input);

        // Test whether the inputted number is a prime or nor
        if(isPrime(testNumber))
            JOptionPane.showMessageDialog(null, testNumber + " is a prime number.");
        else
            JOptionPane.showMessageDialog(null, testNumber + " is a NOT a prime number.");

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
