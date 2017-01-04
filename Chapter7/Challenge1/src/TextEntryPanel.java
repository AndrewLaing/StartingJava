/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * The TextEntryPanel class creates the text entry panel
 */
public class TextEntryPanel extends JPanel
{
    private JLabel wholesaleLabel;
    private JTextField wholesaleTextField;
    private JLabel markupLabel;
    private JTextField markupTextField;

    /**
     * Constructor
     */
    public TextEntryPanel()
    {
        wholesaleLabel = new JLabel("Wholesale price: ");
        markupLabel = new JLabel("Markup percentage: ");
        wholesaleTextField = new JTextField(10);
        markupTextField = new JTextField(10);

        // use a gridLayout manager for the panel
        setLayout(new GridLayout(2, 2));

        // add the components
        add(wholesaleLabel);
        add(wholesaleTextField);
        add(markupLabel);
        add(markupTextField);

        // create a border around the panel
        setBorder(BorderFactory.createTitledBorder("Enter data"));
    }


    /**
     * The displayRetailPrice method either displays the calculated retail price
     * or an error message
     */
    public void displayRetailPrice()
    {
        String input = "";              // to hold the user's input
        double wholesalePrice = 0.0;    // to hold the wholesale price in
        double markupPercentage = 0.0;
        double total = 0.0;

        DecimalFormat pounds = new DecimalFormat("#,##00.00");

        // Validate and set the wholesalePrice
        input = wholesaleTextField.getText();
        if(input.equals("") == true)
        {
            JOptionPane.showMessageDialog(null, "Error - Wholesale Price field must be completed!");
            return;
        }

        try {
            wholesalePrice = Double.parseDouble(input);
        }
        catch (Exception e) // If the text field contains non numeric data
        {
            JOptionPane.showMessageDialog(null, "Error - Wholesale Price must be a numeric value!");
            return;
        }

        // Validate and set the markupPercentage
        input = markupTextField.getText();
        if(input.equals("") == true)
        {
            JOptionPane.showMessageDialog(null, "Error - Markup Percentage field must be completed!");
            return;
        }

        try {
            markupPercentage = Double.parseDouble(input);
        }
        catch (Exception e) // If the text field contains non numeric data
        {
            JOptionPane.showMessageDialog(null, "Error - Markup Percentage must be a numeric value!");
            return;
        }

        // Calculate the retail price
        markupPercentage /= 100.0; // convert into 10% into 0.1 etc
        total = wholesalePrice + (wholesalePrice * markupPercentage);

        input = "The Retail Price is $" + pounds.format(total);
        JOptionPane.showMessageDialog(null, input);
        return;
    }
}
