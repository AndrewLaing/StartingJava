/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   08/09/2016.
 */

import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {
        // Create a Scanner object for the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        int numberOfStores = 5;
        int[] sales = new int[numberOfStores];   // Create an array to put each store's sales in
        int temp;                   // Used to temporarily store the user's input whilst it is validated

        // Get the user to input the sales for each store
        for(int i=0; i<numberOfStores; i++)
        {
            System.out.print("Enter today's sales for store " + (i+1) + ": ");
            temp = keyboard.nextInt();

            while (temp < 0)
            {
                System.out.println("\nError - today's sales can not be less than zero!\n");

                System.out.print("Enter today's sales for store " + (i+1) + ": ");
                temp = keyboard.nextInt();
            }

            sales[i] = temp;
        }

        // Display the bar chart
        System.out.println("\nSALES BAR CHART");
        for(int i=0; i<numberOfStores; i++)
        {
            System.out.printf("Store %d: ", (i+1));

            // Get the sales for the store
            temp = sales[i];
            // print out the asterisks
            for(int asterisk=0; asterisk<temp; asterisk+=100)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
