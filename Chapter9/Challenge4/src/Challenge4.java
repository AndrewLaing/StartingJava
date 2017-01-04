/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */

import java.util.Scanner;

public class Challenge4
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        double length, width;

        // Create the first Land Tract
        System.out.print("Enter the length of Land Tract 1: ");
        length = keyboard.nextDouble();

        System.out.print("Enter the width of Land Tract 1: ");
        width = keyboard.nextDouble();

        LandTract lt1 = new LandTract(length, width);


        // Create the second Land Tract
        System.out.print("Enter the length of Land Tract 2: ");
        length = keyboard.nextDouble();

        System.out.print("Enter the width of Land Tract 2: ");
        width = keyboard.nextDouble();

        LandTract lt2 = new LandTract(length, width);


        System.out.println("The area of tract 1 is " + lt1.getArea());
        System.out.println("The area of tract 2 is " + lt2.getArea());

        // Check whether the second LandTract is the same as the first
        if(lt1.equals(lt2))
            System.out.println("The two tracts of land have the same dimensions.");
        else
            System.out.println("The two tracts of land do NOT have the same dimensions.");
    }

}
