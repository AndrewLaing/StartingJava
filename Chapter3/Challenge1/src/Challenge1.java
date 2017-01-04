/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   22/08/2016.
 */

import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {
        int userNum;        // To hold the user's input
        String romanNum;    // To hold the Roman Numeral created from the user's input

        // Create a new scanner object for the keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Get the user to input a number
        System.out.print("Please enter a number between 1 and 10: ");
        userNum = keyboard.nextInt();

        // Print out a Roman numeral based upon the user's input
        switch (userNum) {
            case 1:
                romanNum = "I";
                break;
            case 2:
                romanNum = "II";
                break;
            case 3:
                romanNum = "III";
                break;
            case 4:
                romanNum = "IV";
                break;
            case 5:
                romanNum = "V";
                break;
            case 6:
                romanNum = "VI";
                break;
            case 7:
                romanNum = "VII";
                break;
            case 8:
                romanNum = "VIII";
                break;
            case 9:
                romanNum = "IX";
                break;
            case 10:
                romanNum = "X";
                break;
            default:
                romanNum = "Invalid - number should be in the range 1 to 10!";
                break;
        }

        // Print out the Roman Numeral or error message.
        System.out.println(romanNum);
    }
}
