/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/11/2016.
 */
public class RetailItem
{
    private String description;
    private int unitsOnHand;
    private double price;


    /**
     * No-arg constructor
     */
    public RetailItem()
    {
        description = "Unknown";
        unitsOnHand = 0;
        price = 0.0;
    }


    /**
     * Overloaded constructor
     * @param desc Description of the item
     * @param uoh Amount of units of the item on hand
     * @param pr Price of the item
     */
    public RetailItem(String desc, int uoh, double pr)
    {
        description = desc;
        unitsOnHand = uoh;
        price = pr;
    }

    /**
     * The method SetDescription sets the value in the description field
     * @param desc The description of the item
     */
    public void setDescription(String desc)
    {
        description = desc;
    }


    /**
     * The method setUnitsOnHand sets the value in the unitsOnHand field
     * @param uoh The amount of units of the item on hand
     */
    public void setUnitsOnHand(int uoh)
    {
        unitsOnHand = uoh;
    }


    /**
     * The method setPrice sets the value in the price field
     * @param pr The price of the item
     */
    public void setPrice(double pr)
    {
        price = pr;
    }


    /**
     * The method getDescription returns the value in the description field
     * @return The value in the description field
     */
    public String getDescription()
    {
        return description;
    }



    /**
     * The method getUnitsOnHand returns the value in the unitsOnHand field
     * @return The value in the unitsOnHand field
     */
    public int getUnitsOnHand()
    {
        return unitsOnHand;
    }


    /**
     * The method getPrice returns the value in the price field
     * @return The value in the price field
     */
    public double getPrice()
    {
        return price;
    }
}

