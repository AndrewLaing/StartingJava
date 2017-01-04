/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   07/09/2016.
 */

import java.util.Scanner;

public class Exercise10
{
    public static void main(String[] args) {
        // Constant used as the sentinel value signalling to exit the loop
        final int sentinel = -99;

        // Create a Scanner object to get the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Variables
        int min=0, max=0;   // Used to store the lowest and highest numbers
        int input;          // Used to temporarily store the user's input

        // Tell the user how the program works
        System.out.println("In the following program you will enter a series of numbers\n" +
                            "and I will find the largest and smallest numbers that you\n" +
                            "have entered. When you wish to exit the program and get me\n" +
                            "to show you the result enter in the value -99\n\n");

        System.out.print("Enter a number: ");
        input = keyboard.nextInt();

        if(input != sentinel)
            min = max = input;

        while(input != sentinel)
        {
            if(input < min)
                min = input;
            else if(input > max)
                max = input;

            System.out.print("Enter number: ");
            input = keyboard.nextInt();
        }

        // Display the results
        System.out.println("\nThe lowest number entered was " + min);
        System.out.println("The highest number entered was " + max);
    }
}
