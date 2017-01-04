/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/08/2016.
 */


import javax.swing.JOptionPane;

public class Challenge11 {
    public static void main(String[] args) {
        final double markup = 0.4;
        double retailPrice, profit;
        String inputString;

        // Get the retail price
        inputString = JOptionPane.showInputDialog("Please enter the retail price in dollars.");

        // Convert input to a double
        retailPrice = Double.parseDouble(inputString);

        // Calculate profit
        profit = retailPrice * markup;
        // Create a formatted string with the result
        String result = String.format("The profit earned from the sale of this product is $%.2f" , profit);

        // Display the result to the user
        JOptionPane.showMessageDialog(null, result);

        System.exit(0);
    }
}
