/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/08/2016.
 */

import java.util.Scanner;

public class Challenge8 {
    public static void main(String[] args) {
        final double countySalesTax = 0.02;
        final double stateSalesTax = 0.04;
        Scanner keyboard = new Scanner(System.in);
        double purchaseAmount, total;

        System.out.print("Please enter the amount of the purchase: ");
        purchaseAmount = keyboard.nextDouble();
        total = purchaseAmount + (purchaseAmount*countySalesTax) + (purchaseAmount*stateSalesTax);

        System.out.printf("Amount of purchase:   $%.2f\n", purchaseAmount);
        System.out.printf("State sales tax due:  $%.2f\n", (purchaseAmount*stateSalesTax));
        System.out.printf("County sales tax due: $%.2f\n", (purchaseAmount*countySalesTax));
        System.out.printf("Total amount due:     $%.2f\n", total);
    }
}
