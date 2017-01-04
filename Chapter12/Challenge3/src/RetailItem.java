/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
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
     * @param description Description of the item
     * @param unitsOnHand Amount of units of the item on hand
     * @param price Price of the item
     */
    public RetailItem(String description, int unitsOnHand, double price)
                    throws NegativeUnitsException, NegativePriceException
    {
        if(unitsOnHand<0) throw new NegativeUnitsException();
        if(price<0) throw new NegativePriceException();

        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
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
     * @param unitsOnHand The amount of units of the item on hand
     */
    public void setUnitsOnHand(int unitsOnHand) throws NegativeUnitsException
    {
        if(unitsOnHand<0) throw new NegativeUnitsException();
        this.unitsOnHand = unitsOnHand;
    }


    /**
     * The method setPrice sets the value in the price field
     * @param price The price of the item
     */
    public void setPrice(double price) throws NegativePriceException
    {
        if(price<0) throw new NegativePriceException();
        this.price = price;
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

