/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/11/2016.
 */
public class Stock
{
    private String symbol;      // trading symbol of stock
    private double sharePrice;  // current trading price of the stock

    /**
     * Constructor
     * @param sym The stock's trading symbol
     * @param price The stock's share price
     */
    public Stock(String sym, double price)
    {
        symbol = sym;
        sharePrice = price;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public double getSharePrice()
    {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String toString()
    {
        /// create a string describing the stock
        String str = "Trading symbol: " + symbol +
                     "\nShare price: " + sharePrice;

        return str;
    }
}
