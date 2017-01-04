/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   22/08/2016.
 */

import java.util.Scanner;

public class Challenge1a {
    public static void main(String[] args) {
        int userNum;        // To hold the user's input
        String romanNum;    // To hold the Roman Numeral created from the user's input
        String[] numerals = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        // Create a new scanner object for the keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Get the user to input a number
        System.out.print("Please enter a number between 1 and 10: ");
        userNum = keyboard.nextInt();
        userNum-=1;

        if(userNum<0 || userNum>9)
            romanNum = "Error - number must be between 1 and 10!";
        else
            romanNum = numerals[userNum];

        // Print out the Roman Numeral or error message.
        System.out.println(romanNum);
    }
}
