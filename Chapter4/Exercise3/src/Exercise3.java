/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/09/2016.
 */

import java.util.Scanner;
import java.io.*;

public class Exercise3 {
    public static void main(String[] args) throws IOException
    {
        // Create a Scanner object for the users keyboard input
        Scanner keyboard = new Scanner(System.in);
        String filename = "reportForExercise3.txt";

        // Open a file to write the results to
        FileWriter fwriter = new FileWriter(filename);
        PrintWriter outputFile = new PrintWriter(fwriter);

        int speed, time;    // Created variables to hold the speed and time

        // Get the user to enter the speed of the vehicle
        System.out.print("Enter the speed of the vehicle, to the nearest whole number,\nin miles-per-hour:  ");
        speed = keyboard.nextInt();

        while(speed<0) {
            System.out.println("Error - input cannot be negative.");
            System.out.print("Enter the speed of the vehicle, to the nearest whole number,\nin miles-per-hour:  ");
            speed = keyboard.nextInt();
        }

        // Get the user to enter the number of hours that the vehicle has been travelling
        System.out.print("Enter the number of hours that the vehicle\nhas been travelling:  ");
        time = keyboard.nextInt();

        while(time<1) {
            System.out.println("Error - input must be greater than zero.");
            System.out.print("Enter the number of hours that the vehicle\nhas been travelling:  ");
            time = keyboard.nextInt();
        }

        // Write the report to the output file
        outputFile.println("Hour        Distance Travelled");
        outputFile.println("-------------------------------");

        for(int hour=1; hour<=time; hour++)
            outputFile.printf("%-20d%d\n", hour, (hour*speed));

        // Close the connection to the file
        outputFile.close();

        // Let the user know that the report has been written
        System.out.println("The report has been written to " + filename);
    }
}
