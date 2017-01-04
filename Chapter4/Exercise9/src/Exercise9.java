/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   07/09/2016.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise9
{
    public static void main(String[] args) {
        // Create some constants used for data validation
        final int minStartSize = 2;       // the minimum start size for the organism population
        final int minDailyGrowth = 0;     // the minimum daily population growth percentage;
        final int minDays = 1;            // the minimum number of days to grow the organisms

        // Variables
        int temp;                   // to temporarily store user input to be validated
        int days;
        double dailyGrowth;
        double totalPopulation;

        // Create a decimal format so that the population does not show decimal places
        DecimalFormat formatter = new DecimalFormat("#,##0");

        // Create a Scanner object for the user's input
        Scanner keyboard = new Scanner(System.in);

        // Get the user to enter the number of organisms to start with
        System.out.print("Enter the number of organisms that you wish to start with: ");
        temp = keyboard.nextInt();

        while(temp < minStartSize)
        {
            System.out.println("\nError - the minimum allowed start population size is " + minStartSize);
            System.out.print("\nEnter the number of organisms that you wish to start with: ");
            temp = keyboard.nextInt();
        }

        totalPopulation = temp;

        // Get the user to enter the number of days that the organisms will multiply for
        System.out.print("Enter the number of days that the organisms will multiply for: ");
        temp = keyboard.nextInt();

        while(temp < minDays)
        {
            System.out.println("\nError - the minimum allowed number of days is " + minDays);
            System.out.print("\nEnter the number of days that the organisms will multiply for: ");
            temp = keyboard.nextInt();
        }

        days = temp;


        // Get the user to enter the daily population growth percentage
        System.out.print("Enter the percentage that the population will grow per day: ");
        temp = keyboard.nextInt();

        while(temp < minDailyGrowth)
        {
            System.out.println("\nError - the minimum daily growth allowed is " + minDailyGrowth + "%");
            System.out.print("Enter the percentage that the population will grow per day: ");
            temp = keyboard.nextInt();
        }

        dailyGrowth = temp / 100.0;

        for(int day=1; day<=days; day++)
        {
            totalPopulation += (totalPopulation * dailyGrowth);
            if(day<2)
                System.out.println("The population after " + day + " day of growth is " + formatter.format(totalPopulation));
            else
                System.out.println("The population after " + day + " days of growth is " + formatter.format(totalPopulation));
        }

    }
}
