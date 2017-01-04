/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/11/2016.
 */

import java.text.DecimalFormat;
import java.io.*;

public class CashRegister
{
    private int quantityOfItems;
    private RetailItem itemOnSale;

    private final double SALES_TAX_RATE = 0.06;

    /**
     * Constructor that makes a copy of the RetailItem passed
     * to it, so the original does not get changed.
     * @param itemOnSale
     */
    public CashRegister(RetailItem itemOnSale)
    {
        this.quantityOfItems = 0;

        this.itemOnSale = new RetailItem();
        this.itemOnSale.setDescription(itemOnSale.getDescription());
        this.itemOnSale.setUnitsOnHand(itemOnSale.getUnitsOnHand());
        this.itemOnSale.setPrice(itemOnSale.getPrice());
    }

    public void setQuantityOfItems(int quantityOfItems)
    {
        this.quantityOfItems = quantityOfItems;
    }


    public int getQuantityOfItems() {
        return quantityOfItems;
    }

    public double getSubtotal()
    {
        return quantityOfItems * itemOnSale.getPrice();
    }

    public double getTax()
    {
        return getSubtotal() * SALES_TAX_RATE;
    }

    public double getTotal()
    {
        return getSubtotal() + getTax();
    }


    public String toString()
    {
        DecimalFormat pounds = new DecimalFormat("£#,##0.00");

        return "Subtotal: " + pounds.format(getSubtotal()) +
                "\nSales Tax: " + pounds.format(getTax()) +
                "\nTotal price: " + pounds.format(getTotal());
    }

    public void printReceipt() throws IOException
    {
        DecimalFormat pounds = new DecimalFormat("£#,##0.00");

        FileWriter fwrite = new FileWriter("receipt.txt");
        PrintWriter output = new PrintWriter(fwrite);

        String receipt = "SALES RECEIPT" +
                         "\nUnit Price: " + pounds.format(itemOnSale.getPrice()) +
                         "\nQuantity: " + quantityOfItems +
                         "\nSubtotal: " + pounds.format(getSubtotal()) +
                         "\nSales Tax: " + pounds.format(getTax()) +
                         "\nTotal: " + pounds.format(getTotal());

        output.println(receipt);
        output.close();
    }
}
