/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/11/2016.
 */

import java.text.DecimalFormat;

public class Challenge1
{
    public static void main(String[] args)
    {
        DecimalFormat output = new DecimalFormat("#0.00");

        System.out.println("The area of the circle is " + output.format( Area.area(6.3) ));
        System.out.println("The area of the rectangle is " + output.format( Area.area(4, 6) ));
        System.out.println("The area of the cylinder is " + output.format( Area.area(6.3, 5) ));
    }
}
