/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   16/01/2017.
 */
import java.text.DecimalFormat;
import java.util.Scanner;


public class Challenge10
{
    // Create some constants used for data validation
    public static final int minStartSize = 2;       // the minimum start size for the organism population
    public static final int minDailyGrowth = 0;     // the minimum daily population growth percentage;
    public static final int minDays = 1;            // the minimum number of days to grow the organisms

    // Create a decimal format so that the population does not show decimal places
    public static final DecimalFormat formatter = new DecimalFormat("#,##0");
    public static double dailyGrowth;


    /*
     * Recursive method to calculate the number of organisms
     */
    public static double showPopulationGrowth(double totalPopulation, int days)
    {
        if(days==0)
            return totalPopulation;

        totalPopulation += (totalPopulation * dailyGrowth);
        //System.out.println("The population is " + formatter.format(totalPopulation));
        totalPopulation = showPopulationGrowth(totalPopulation, days-1);

        return totalPopulation;
    }




    public static void main(String[] args) {


        // Variables
        int temp;                   // to temporarily store user input to be validated
        int days;
        double totalPopulation;

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

        System.out.println("The total population after " + days +
                           " days of growth = " +
                           formatter.format(showPopulationGrowth(totalPopulation, days)));
    }
}
