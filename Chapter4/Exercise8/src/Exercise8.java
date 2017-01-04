/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/09/2016.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercise8
{
    public static void main(String[] args) {
        // Create a Scanner object to hold the users keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Create a DecimalFormat object used to print the average rainfall
        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Create some constants
        final int months = 12;      // number of months in a year
        final int minYears = 1;     // the minimum number of years the average can be calculated for
        final int minRainfall = 0;  // the minimum amount of rainfall per month

        String[] monthNames = {"January","February","March","April","May","June",
                               "July","August","September","October","November","December"};
        int temp;               // used to store user input whilst it is being validated
        int years;              // used to store the number of years
        int totalRainfall = 0;  // used to store the total amount of rainfall
        double averageRainfall; // the average amount of rainfall for the period
        int totalMonths;        // the total number of months


        // Get the user to enter the number of years to calculate the average for
        System.out.print("How many years do you wish to enter data for: ");
        temp = keyboard.nextInt();

        while(temp<1) {
            System.out.println("Error - the minimum number of years allowed is 1!");

            System.out.print("How many years do you wish to enter data for: ");
            temp = keyboard.nextInt();
        }

        years = temp;

        // Get the rainfall data for each year
        for(int year=1; year<=years; year++)
        {
            System.out.println("\n---- Enter the rainfall for year " + year + " ----\n");

            for (int i = 0; i < months; i++)
            {
                System.out.print(monthNames[i] + ": ");
                temp = keyboard.nextInt();

                while(temp<0) {
                    System.out.println("\nError - the amount of rainfall cannot be less than zero!\n");

                    System.out.print("Enter the amount of rainfall for " + monthNames[i] + ": ");
                    temp = keyboard.nextInt();
                }

                totalRainfall += temp;
            }
        }

        totalMonths = years * months;
        averageRainfall = (double)totalRainfall / totalMonths;

        // Display the result
        System.out.println("\n ----- RESULT -----\n");
        System.out.println("Over a total period of " + totalMonths + " months, there was a total amount of " +
                totalRainfall + " inches of rainfall.\nThis means that the average rainfall per month " +
                "for this period was " + formatter.format(averageRainfall) + " inches.");
    }
}
