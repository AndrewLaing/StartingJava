/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */

import java.util.Scanner;

public class Challenge6
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        RetailItem chocolateBars = new RetailItem("Ferrero Rocher Chocolates", 200, 3.50);
        CashRegister myCashRegister = new CashRegister(chocolateBars);

        int quantityRequired;
        System.out.print("How many " + chocolateBars.getDescription() + " do you want?");
        quantityRequired = keyboard.nextInt();

        if(quantityRequired<=chocolateBars.getUnitsOnHand())
        {
            myCashRegister.setQuantityOfItems(quantityRequired);
            System.out.println(myCashRegister);
        }
        else
            System.out.println("Sorry we do not have that many items in stock.");
    }
}
