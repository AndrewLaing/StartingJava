/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   26/11/2016.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Challenge9
{
    public static void printMenu()
    {
        System.out.print("Geometry Calculator" +
                            "\n1.   Calculate the Area of a Circle" +
                            "\n2.   Calculate the Area of a Rectangle" +
                            "\n3.   Calculate the Area of a Triangle" +
                            "\n4.   Quit" +
                            "\n" +
                            "\nEnter your choice (1-4): ");
    }


    public static double getADouble(String toGet)
    {
        Scanner keyboard = new Scanner(System.in);
        double choice = 0;     // used to hold the user's choice

        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Please enter the " + toGet + ": ");
            try {
                choice = keyboard.nextDouble();
                if (choice > 0)
                    validChoice = true;
                else {
                    System.out.println("\nError - Number must be greater than zero!\nPlease try again\n");
                }
            } catch (Exception e) {
                System.out.println("\nError - Invalid input!\nPlease try again\n");

            }
        }

        return choice;
    }


    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat output = new DecimalFormat("#0.00");
        int choice = 0;     // used to hold the user's choice

        boolean validChoice = false;
        boolean getUserInput = true;
        String result = "";

        // Continue until the user selects option 4
        while(getUserInput)
        {
            while (!validChoice)
            {
                printMenu();
                try {
                    choice = keyboard.nextInt();
                    if (choice > 0 && choice < 5)
                        validChoice = true;
                    else {
                        System.out.println("\nError - Number must be in the range 1 through 4!\nPlease try again\n");
                    }
                } catch (Exception e) {
                    System.out.println("\nError - Invalid input!\nPlease try again\n");

                }
            }

            switch (choice)
            {
                case 1:
                    result = "\nThe area of the Circle = ";
                    result += output.format( Geometry.areaOfCircle( getADouble("radius") ) );
                    break;
                case 2:
                    result = "\nThe area of the Rectangle = ";
                    result += output.format( Geometry.areaOfRectangle( getADouble("length"), getADouble("width") ));
                    break;
                case 3:
                    result = "\nThe area of the Triangle = ";
                    result += output.format( Geometry.areaOfTriangle( getADouble("base"), getADouble("height") ));
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    getUserInput = false;
                    break;
                default:
                    System.out.println("Error - this statement should never print. Check the code!!!!");
                    getUserInput = false;
                    break;
            }

            System.out.println(result);
            System.out.println();

            validChoice = false; // reset validChoice to false so can make another choice from the menu
        }

    }
}
