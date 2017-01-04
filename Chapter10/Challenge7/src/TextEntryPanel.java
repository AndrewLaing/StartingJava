/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * The TextEntryPanel class creates the text entry panel
 */
public class TextEntryPanel extends JPanel
{
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel amountLabel;
    private JTextField amountTextField;


    /**
     * Constructor
     */
    public TextEntryPanel()
    {
        dateLabel = new JLabel("Date: ");
        nameLabel = new JLabel("Name: ");
        amountLabel = new JLabel("Amount: ");
        dateTextField = new JTextField(10);
        nameTextField = new JTextField(10);
        amountTextField = new JTextField(10);

        // use a gridLayout manager for the panel
        setLayout(new GridLayout(3, 2));

        // add the components
        add(dateLabel);
        add(dateTextField);
        add(nameLabel);
        add(nameTextField);
        add(amountLabel);
        add(amountTextField);


        // create a border around the panel
        setBorder(BorderFactory.createTitledBorder("Enter customer details"));
    }

    public String[] numbers1 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                "ten",  "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                                "seventeen", "eighteen", "nineteen",
                                "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
                                "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine",
                                "thirty", "thirty one", "thirty two", "thirty three", "thirty four",
                                "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine",
                                "fourty", "fourty one", "fourty two", "fourty three", "fourty four",
                                "fourty five", "fourty six", "fourty seven", "fourty eight", "fourty nine",
                                "fifty", "fifty one", "fifty two", "fifty three", "fifty four",
                                "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine",
                                "sixty", "sixty one", "sixty two", "sixty three", "sixty four",
                                "sixty five", "sixty six", "sixty seven", "sixty eight", "sixty nine",
                                "seventy", "seventy one", "seventy two", "seventy three", "seventy four",
                                "seventy five", "seventy six", "seventy seven", "seventy eight", "seventy nine",
                                "eighty", "eighty one", "eighty two", "eighty three", "eighty four",
                                "eighty five", "eighty six", "eighty seven", "eighty eight", "eighty nine",
                                "ninety", "ninety one", "ninety two", "ninety three", "ninety four",
                                "ninety five", "ninety six", "ninety seven", "ninety eight", "ninety nine"
    };



    public String getAmountString(double amount)
    {
        String result = "";
        if(amount<1)
            result += "Zero pounds and ";

        if(amount >= 1000)
        {
            int count = 0;
            while(amount >= 1000) {
                amount -= 1000;
                count++;
            }

            result += numbers1[count] + " thousand";
        }

        if(amount >= 100)
        {
            int count = 0;
            while(amount >= 100) {
                amount -= 100;
                count++;
            }

            if(result.length() > 0 )
                result += " ";

            result += numbers1[count] + " hundred";
        }

        if(amount >= 1)
        {
            int count = 0;
            while(amount >= 1) {
                amount -= 1;
                count++;
            }

            if(result.length() > 0 )
                result += " and ";

            result += numbers1[count] + " pounds and ";


        }
        else {
            if(result.startsWith("Zero")==false)
                result += " pounds and ";
        }


        // Get the index for the text equivalent of the remainder
        int remainder = (int)Math.round(amount*100.0);
        result += numbers1[remainder] + " pence.";

        // Capitalise the first letter of the result
        if(result.length() > 1)
            result = Character.toUpperCase(result.charAt(0)) +
                    result.substring(1);

        return result;

    }



    public void printCheck()
    {
        String date = dateTextField.getText();
        String name = nameTextField.getText();
        String amount = amountTextField.getText();

        if(date.length() == 0 || name.length() == 0 || amount.length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Error - All fields must be completed.");
            return;
        }

        if(amount.length() > 7)
        {
            JOptionPane.showMessageDialog(null, "Sorry - we cannot issue sums that large!!!");
            return;
        }

        double amt = 0;
        try {
            amt = Double.parseDouble(amount);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error - All fields must be completed.");
            return;
        }


        if(amt >= 10000 )
        {
            JOptionPane.showMessageDialog(null, "Sorry - we cannot issue sums that large!!!");
            return;
        }

        String amountToText = getAmountString(amt);

        String check = " \n\t\t\t\tDate:\t" + date +
                        "\nPay to the order of:\t" + name + "\t\t\t£" + amount +
                        "\n" + amountToText +
                        "\n ";

        JOptionPane.showMessageDialog(null, new JTextArea(check));
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
        input = nameTextField.getText();
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
        input = nameTextField.getText();
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
