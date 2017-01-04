/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/09/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge11
{

    public static void main(String[] args)
    {
        float profit = 0; //getProfit( getNS(), getPP(), getPC(), getSP(), getSC() );

        DecimalFormat pounds = new DecimalFormat("#,##0.00");
        String message;

        int stocks = getStocks();

        for(int i=0; i<stocks; i++)
        {
            JOptionPane.showMessageDialog(null, "Entering the details for stock number " +
                                                 (i + 1));
            profit += getProfit( getNS(), getPP(), getPC(), getSP(), getSC() );
        }




        if(profit==0F)
        {
            message = "You made nothing and lost nothing on these investments.\n" +
                    "The total profits were £" + pounds.format(profit);
        }
        else if(profit<0)
        {
            message = "You made a bad investment.\n" +
                    "Your total losses on these investments were £" + pounds.format( Math.abs(profit) );
        }
        else
        {
            message = "You made a good investment.\n" +
                    "Your total profit on these investments was £" + pounds.format( profit );
        }

        JOptionPane.showMessageDialog(null, message);

        // Close the thread created by the message dialogue
        System.exit(0);


    }

    /**
     * The method getStocks gets the user to input the
     * number of different stocks traded
     * @return The number of different stocks traded as an integer
     */
    public static int getStocks()
    {
        int stocks;
        String input = JOptionPane.showInputDialog("Enter the number of diffferent stocks that you traded in");

        stocks = Integer.parseInt(input);
        return stocks;
    }


    /**
     * The method getNS gets the user to input the
     * number of shares bought.
     * @return The number of shares bought as a float
     */
    public static float getNS()
    {
        float NS;
        String input = JOptionPane.showInputDialog("Enter the number of shares");

        NS = Float.parseFloat(input);
        return NS;
    }


    /**
     * The method getPP gets the user to input the
     * purchase price per share
     * @return The purchase price per share as a float
     */
    public static float getPP()
    {
        float PP;
        String input = JOptionPane.showInputDialog("Enter the purchase price per share");

        PP = Float.parseFloat(input);
        return PP;
    }


    /**
     * The method getPC gets the user to input the
     * purchase commission paid.
     * @return The purchase commission as a float
     */
    public static float getPC()
    {
        float PC;
        String input = JOptionPane.showInputDialog("Enter the purchase commission paid");

        PC = Float.parseFloat(input);
        return PC;

    }


    /**
     * The method getSP gets the user to input the
     * sales price per share
     * @return The sale price per share as a float
     */
    public static float getSP()
    {
        float SP;
        String input = JOptionPane.showInputDialog("Enter the sale price per share");

        SP = Float.parseFloat(input);
        return SP;
    }


    /**
     * The method getSC gets the user to input the
     * sales commission paid
     * @return The sales commission paid as a float
     */
    public static float getSC()
    {
        float SC;
        String input = JOptionPane.showInputDialog("Enter the sales commission paid");

        SC = Float.parseFloat(input);
        return SC;

    }


    /**
     * The method getProfit calculates the profit or loss made
     * on the user's share transaction
     * @param NS Number of shares bought
     * @param PP Purchase price per share
     * @param PC Purchase commission paid
     * @param SP Sales price per share
     * @param SC Sales commission paid
     * @return The total profit or loss made on the transaction
     */
    public static float getProfit(float NS, float PP, float PC, float SP, float SC)
    {
        return ((NS * SP) - SC) - ((NS * PP) + PC);
    }

}
