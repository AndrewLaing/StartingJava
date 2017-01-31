/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/01/2017.
 */

import java.util.Scanner;

public class Challenge4
{

    public static void main(String[] args)
    {
        int result = -1;
        int searchValue;
        String input;

        // an array of numbers to search
        int numbers[] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                         8080152, 4562555, 5552012, 5050522, 7825877, 1250255,
                         1005231, 6545231, 3852085, 7576651, 7881200, 4581002};

        Scanner keyboard = new Scanner(System.in);


        do {
            // Get a value to search for
            System.out.print("Enter your Charge Account Number: ");
            searchValue = keyboard.nextInt();

            result = IntSequentialSearcher.search(numbers, searchValue);

            // display the results
            if(result == -1){
                System.out.println("Error - You have entered an INVALID number.");
            } else {
                System.out.println("Your number has been VERIFIED.");
            }

            // consume the remaining newline
            keyboard.nextLine();

            // does the user want to search again?
            System.out.print("Continue entering Charge Account numbers? (Y or N): ");
            input = keyboard.nextLine();

        } while(input.charAt(0)=='Y' || input.charAt(0)=='y');
    }
}
