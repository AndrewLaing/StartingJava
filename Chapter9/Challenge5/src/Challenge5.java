/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */

import java.util.Scanner;

public class Challenge5
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String input;
        int month2;

        // Note test data = June, 6
        System.out.print("Enter the name of the first month: ");
        input = keyboard.nextLine();

        Month mth1 = new Month(input);

        System.out.print("Enter the number of the second month: ");
        month2 = keyboard.nextInt();

        Month mth2 = new Month(month2);
        Month mth3 = new Month();

        System.out.println("The names of the months are " +
                            mth1 + " " + mth2.getMonthName() + " " + mth3);

        if(mth1.equals(mth2))
            System.out.println("Month 1 is the same as Month 2");
        else
            System.out.println("Month 1 is NOT the same as Month 2");

        if(mth2.greaterThan(mth3))
            System.out.println("Month 2 is after Month 3");
        else
            System.out.println("Month 2 is NOT after Month 3");


        if(mth3.lessThan(mth2))
            System.out.println("Month 3 is before Month 2");
        else
            System.out.println("Month 3 is NOT before Month 2");

    }
}
