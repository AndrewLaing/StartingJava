/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/08/2016.
 */

import java.util.Scanner;

public class Challenge3
{
    public static void main(String[] args)
    {
        int widthA, heightA, areaA;     // To store the attributes of rectangle A
        int widthB, heightB, areaB;     // To store the attributes of rectangle B

        // Create a Scanner object to get input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Get the width and height of Rectangle A
        System.out.print("Enter the width of Rectangle A: ");
        widthA = keyboard.nextInt();

        System.out.print("Enter the height of Rectangle A: ");
        heightA = keyboard.nextInt();

        // Get the width and height of Rectangle A
        System.out.print("Enter the width of Rectangle B: ");
        widthB = keyboard.nextInt();

        System.out.print("Enter the height of Rectangle B: ");
        heightB = keyboard.nextInt();

        // Calculate the areas
        areaA = widthA * heightA;
        areaB = widthB * heightB;

        // Print the result to the user
        if(areaA==areaB)
            System.out.print("The Rectangles have the same size areas.");
        else if(areaA>areaB)
            System.out.print("Rectangle A has a larger area than Rectangle B");
        else
            System.out.print("Rectangle B has a larger area than Rectangle A");
    }
}
