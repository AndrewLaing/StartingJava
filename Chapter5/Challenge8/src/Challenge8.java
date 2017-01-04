/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/09/2016.
 */

import java.util.Scanner;           // for the Scanner class
import java.text.DecimalFormat;     // for the DecimalFormat class

public class Challenge8
{
    public static void main(String[] args)
    {
        int choice = 0;
        float distanceMeters;
        Scanner keyboard = new Scanner(System.in);


        System.out.print("\nEnter the distance in meters: ");
        distanceMeters = keyboard.nextFloat();

        while (distanceMeters<0)
        {
            System.out.println("ERROR - The distance must be a positive number!");
            System.out.print("\nEnter the distance in meters: ");
            distanceMeters = keyboard.nextFloat();
        }

        do
        {
            menu();
            choice = keyboard.nextInt();

            if (choice==1)
                showKilometers(distanceMeters);
            else if(choice==2)
                showInches(distanceMeters);
            else if (choice==3)
                showFeet(distanceMeters);
            else if(choice==4)
                System.out.println("Bye!");
            else
                System.out.println("\nERROR - Invalid option.\nPlease try again!");


        } while (choice!=4);

    }


    public static void showKilometers(float distanceMeters)
    {
        DecimalFormat formatter = new DecimalFormat("#0.0");
        float kilometers = distanceMeters * 0.001F;
        System.out.println(formatter.format(distanceMeters) + " meters is " +
                           formatter.format(kilometers) + " kilometers.");

    }


    public static void showInches(float distanceMeters)
    {
        DecimalFormat formatter = new DecimalFormat("#0.0");
        float inches = distanceMeters * 39.37F;
        System.out.println(formatter.format(distanceMeters) + " meters is " +
                           formatter.format(inches) + " inches.");

    }


    public static void showFeet(float distanceMeters)
    {
        DecimalFormat formatter = new DecimalFormat("#0.0");
        float feet = distanceMeters * 3.281F;
        System.out.println(formatter.format(distanceMeters) + " meters is " +
                           formatter.format(feet) + " feet.");

    }


    public static void menu()
    {
        System.out.println("\n========================");
        System.out.println("         MENU");
        System.out.println("========================");
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit the program");
        System.out.println("========================");
        System.out.print("Enter your choice: ");
    }
}
