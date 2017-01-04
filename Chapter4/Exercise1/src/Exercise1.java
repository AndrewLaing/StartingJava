/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/09/2016.
 */

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        // Create a Scanner object for the users keyboard input
        Scanner keyboard = new Scanner(System.in);
        int max;

        // Get the user to enter the maximum value
        System.out.print("Enter a number greater than zero: ");
        max = keyboard.nextInt();

        // Only accept a number greater than zero
        while(max<=0) {
            System.out.println("Error - The number must be greater than zero! Try again. ");
            System.out.print("Enter a number greater than zero: ");
            max = keyboard.nextInt();
        }

        // Print out all the positive integers between 1 and the users number
        for(int i=1; i<=max; i++)
            System.out.print(i + " ");

        System.out.println();
    }
}
