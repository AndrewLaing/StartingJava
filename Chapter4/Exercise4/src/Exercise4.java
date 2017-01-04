/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/09/2016.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercise4 {
    public static void main(String[] args) {
        // Create a Scanner object for the users keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Create a DecimalFormat object for the dollar output
        DecimalFormat formatter = new DecimalFormat("#,##0.00");

        int daysWorked;
        double dailyPay = 0.01;
        double totalPay = 0;

        // Get the user to eneter the number of days worked
        System.out.print("Enter the number of days that you worked: ");
        daysWorked = keyboard.nextInt();

        while(daysWorked<1) {
            System.out.println("Error - days worked cannot be less than one!");
            System.out.print("Enter the number of days that you worked: ");
            daysWorked = keyboard.nextInt();
        }

        // Print the report
        System.out.println("Day             Salary");
        System.out.println("-----------------------");

        for(int i=1; i<=daysWorked; i++)
        {
            System.out.printf("%-15d$%s\n",i,formatter.format(dailyPay));
            totalPay += dailyPay;
            dailyPay += dailyPay;
        }
        System.out.println("-----------------------");
        System.out.println("Total salary:  $" + formatter.format(totalPay));
    }
}
