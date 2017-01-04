/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/09/2016.
 */

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        // Create a Scanner object for the users keyboard input
        Scanner keyboard = new Scanner(System.in);

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

        System.out.println("Hour        Distance Travelled");
        System.out.println("-------------------------------");

        for(int hour=1; hour<=time; hour++)
            System.out.printf("%-20d%d\n", hour, (hour*speed));
    }
}
