/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   08/09/2016.
 */

import java.text.DecimalFormat;

public class Exercise11 {
    public static void main(String[] args)
    {
        // Create a DecimalFormat object to print out the temperature in Fahrenheit
        DecimalFormat formatter = new DecimalFormat("#0.0");

        double fahrenheit;

        System.out.println("Centigrade    Fahrenheit");
        System.out.println("------------------------");

        for(int centigrade=0; centigrade<=20; centigrade++)
        {
            fahrenheit = (centigrade * (9.0/5)) + 32;
            System.out.printf("    %-13d%s\n",centigrade,formatter.format(fahrenheit));
        }

    }
}
