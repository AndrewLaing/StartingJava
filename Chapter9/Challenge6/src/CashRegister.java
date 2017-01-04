/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */

import java.text.DecimalFormat;

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
                "\nAmount of sales tax: " + pounds.format(getTax()) +
                "\nTotal price: " + pounds.format(getTotal());
    }
}
