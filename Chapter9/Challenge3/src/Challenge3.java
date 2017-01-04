/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Challenge3
{
    public static void main(String[] args)
    {
        double length, width, cost, totalCost;

        DecimalFormat pounds = new DecimalFormat("£#,##0.00");
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the length of the room in feet: ");
        length = keyboard.nextDouble();

        System.out.print("Enter the width of the room in feet: ");
        width = keyboard.nextDouble();

        System.out.print("Enter the price of the carpet per square foot: ");
        cost = keyboard.nextDouble();

        RoomDimension myRoom = new RoomDimension(length, width);
        RoomCarpet myCarpet = new RoomCarpet(myRoom, cost);
        totalCost = myCarpet.getTotalCost();

        System.out.println("\nThe total cost of the carpet will be: " + pounds.format(totalCost));
        System.out.println(myCarpet);
    }
}
