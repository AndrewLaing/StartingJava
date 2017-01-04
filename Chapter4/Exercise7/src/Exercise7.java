/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/09/2016.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercise7
{
    public static void main(String[] args) {
        // Create a Scanner object to get the user's input
        Scanner keyboard = new Scanner(System.in);

        // Create a DecimalFormat object for printing out the occupancy rate
        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Create two constants used for input validation
        final int minFloors = 1;            // The minimum number of floors the hotel can have
        final int minRoomsPerFloor = 10;    // The minimum number of rooms each floor can have

        int temp;               // to temporarily hold the user's input while it is validated
        int floors = 0;         // the number of floors that the hotel has
        int totalRooms = 0;     // the total number of rooms in the hotel
        int occupied;           // the number of occupied rooms on a floor
        int totalOccupied = 0;  // the total number of occupied rooms
        int totalVacant = 0;    // the total number of vacant rooms
        double occupancyRate;   // the hotel's occupancy rate

        // Ask the user to enter the number of floors
        System.out.print("Enter the number of floors: ");
        temp = keyboard.nextInt();

        while( temp < minFloors )
        {
            System.out.println("\nError - the minimum number of floors \n" +
                               "that a hotel can have is " + minFloors);
            System.out.print("\nEnter the number of floors: ");
            temp = keyboard.nextInt();
        }

        floors = temp;

        // Get the user to input the details for each floor
        for(int i=0; i<floors; i++)
        {
            // Ask the user to enter the number of rooms for the floor
            System.out.print("\nEnter the number of rooms on Floor " + i + ": ");
            temp = keyboard.nextInt();

            while( temp < minRoomsPerFloor )
            {
                System.out.println("\nError - the minimum number of rooms per floor\n" +
                        "that a hotel can have is " + minRoomsPerFloor);
                System.out.print("\nEnter the number of rooms on Floor " + i + ": ");
                temp = keyboard.nextInt();
            }
            totalRooms += temp;

            // Ask the user to enter the number of occupied rooms for the floor
            System.out.print("How many of these rooms are occupied?: ");
            occupied = keyboard.nextInt();

            while( temp < occupied )
            {
                System.out.println("\nError - the number of occupied rooms on this floor\n" +
                        "cannot be greater than the number of rooms on this floor!");
                System.out.print("\nHow many of these rooms are occupied?: ");
                occupied = keyboard.nextInt();
            }
            totalOccupied = occupied;
        }

        // Calculate the number of vacant rooms and the occupancy rate
        totalVacant = totalRooms - totalOccupied;
        occupancyRate = (totalOccupied / (double)totalRooms) * 100.0;

        // Display the results
        System.out.println("\n---- Statistics for the hotel ----");
        System.out.println("Number of rooms:          " + totalRooms);
        System.out.println("Number of occupied rooms: " + totalOccupied);
        System.out.println("Number of vacant rooms:   " + totalVacant);
        System.out.println("Occupancy Rate:           " + formatter.format(occupancyRate) + "%");
    }
}
