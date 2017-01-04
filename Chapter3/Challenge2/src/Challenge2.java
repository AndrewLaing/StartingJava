/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/08/2016.
 */

import java.util.Scanner;

public class Challenge2 {
    public static void main(String[] args) {
        String input;       // To store the use input

        // Create a Scanner object to get input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Get the user's input
        System.out.print("Please enter the state abbbreviation: ");
        input = keyboard.nextLine();

        // Do a quick validation on the user input
        if(input.length()!=2) {
            System.out.println("Error - abbreviation must be 2 characters long.");
            System.exit(0);
        }

        input = input.toUpperCase();

        if(input.equals("NC"))
            System.out.println("North Carolina.");
        else if(input.equals("SC"))
            System.out.println("South Carolina.");
        else if(input.equals("GA"))
            System.out.println("Georgia.");
        else if(input.equals("FL"))
            System.out.println("Florida.");
        else if(input.equals("AL"))
            System.out.println("Alabama.");
        else
            System.out.println("Error - State abbreviation not recognised!");
    }
}
