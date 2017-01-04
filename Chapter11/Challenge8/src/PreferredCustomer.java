/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/12/2016.
 */
public class PreferredCustomer extends Customer
{
    private double purchasesMade;
    private int discountLevel;

    public PreferredCustomer()
    {
        super();
        purchasesMade = 0.0;
        discountLevel = 0;
    }

    /**
     * Copy Constructor
     * @param object2 The object to be copied
     */
    public PreferredCustomer(PreferredCustomer object2)
    {
        super(object2.getName(), object2.getAddress(), object2.getTelephoneNumber(),
                object2.getCustomerNumber(), object2.getOnMailingList());
        this.purchasesMade = object2.getPurchasesMade();
        this.discountLevel = object2.getDiscountLevel();
    }

    /**
     * Copy Constructor
     * @param object2 The object to be copied
     */
    public PreferredCustomer(Customer object2, double purchasesMade)
    {
        super(object2.getName(), object2.getAddress(), object2.getTelephoneNumber(),
                object2.getCustomerNumber(), object2.getOnMailingList());
        this.purchasesMade = purchasesMade;
        this.discountLevel = calculateDiscountLevel();
    }


    public void setPurchasesMade(double purchasesMade) {
        this.purchasesMade = purchasesMade;
        this.discountLevel = calculateDiscountLevel();
    }

    public double getPurchasesMade() {
        return purchasesMade;
    }

    public void setDiscountLevel(int discountLevel) {
        this.discountLevel = discountLevel;
    }

    public int getDiscountLevel() {
        return discountLevel;
    }

    public int calculateDiscountLevel()
    {
        int discount = 0;
        if(purchasesMade >= 2000.0)
            discount = 10;
        else if(purchasesMade >= 1500.0)
            discount = 7;
        else if(purchasesMade >= 1000.0)
            discount = 6;
        else if(purchasesMade >= 500.0)
            discount = 5;

        return discount;
    }


    public String toString() {
        return super.toString() +
                "\n\nPurchases Made: " + getPurchasesMade() +
                "\nDiscount on future purchase: " + getDiscountLevel() + " percent";
    }
}
