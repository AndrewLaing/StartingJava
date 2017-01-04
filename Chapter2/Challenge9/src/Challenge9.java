/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/08/2016.
 */

import java.util.Scanner;   // Needed for the Scanner class

public class Challenge9 {
    public static void main(String[] args) {
        double milesDriven, gallonsUsed, mpg;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the number of miles driven: ");
        milesDriven = keyboard.nextDouble();

        System.out.print("Please enter the amount of gallons of gas used: ");
        gallonsUsed = keyboard.nextDouble();

        mpg = milesDriven / gallonsUsed;

        System.out.printf("Your car runs at %.2f Miles per Gallon\n", mpg);
    }
}
