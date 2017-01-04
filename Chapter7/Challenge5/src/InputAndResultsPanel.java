

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   26/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class InputAndResultsPanel extends JPanel
{

    // Constants for the result calculation
    private final float THEATRE_PERCENTAGE = 0.2F;  // Theatre percentage of ticket sales is 20%


    // Inner Panels
    private JPanel inputPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    // Descriptive labels
    private JLabel adultPriceLabel;
    private JLabel adultSoldLabel;
    private JLabel childPriceLabel;
    private JLabel childSoldLabel;
    private JLabel grossAdultRevenueLabel;
    private JLabel netAdultRevenueLabel;
    private JLabel grossChildRevenueLabel;
    private JLabel netChildRevenueLabel;
    private JLabel totalGrossRevenueLabel;
    private JLabel totalNetRevenueLabel;


    // Results labels
    private JLabel grossAdultRevenueResultLabel;
    private JLabel netAdultRevenueResultLabel;
    private JLabel grossChildRevenueResultLabel;
    private JLabel netChildRevenueResultLabel;
    private JLabel totalGrossRevenueResultLabel;
    private JLabel totalNetRevenueResultLabel;

    // Text input box for the property value
    private JTextField adultPriceText;
    private JTextField adultSoldText;
    private JTextField childPriceText;
    private JTextField childSoldText;

    // Action Buttons
    private JButton calcButton;
    private JButton exitButton;

    // Variables for holding user input
    private float adultPrice = 0.0F;
    private int adultSold = 0;
    private float childPrice = 0.0F;
    private int childSold = 0;

    // Variables for holding results
    private float grossAdultRevenue = 0.0F;
    private float netAdultRevenue = 0.0F;
    private float grossChildRevenue = 0.0F;
    private float netChildRevenue = 0.0F;
    private float totalGrossRevenue = 0.0F;
    private float totalNetRevenue = 0.0F;


    /**
     * Constructor
     */
    public InputAndResultsPanel()
    {
        // Create the panels
        createInputPanel();
        createResultPanel();
        createButtonPanel();

        setLayout(new BorderLayout());

        // add the panels to the InputAndResults Panel
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    /**
     * Method to create the input panel
     */
    private void createInputPanel()
    {
        // create the input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter data"));

        // create the descriptive labels
        adultPriceLabel = new JLabel("Price per Adult ticket: ");
        adultSoldLabel = new JLabel("Number of Adult tickets sold: ");
        childPriceLabel = new JLabel("Price per Child ticket: ");
        childSoldLabel = new JLabel("Number of Child tickets sold: ");

        // create the text boxes
        adultPriceText = new JTextField(10);
        adultSoldText = new JTextField(10);
        childPriceText = new JTextField(10);
        childSoldText = new JTextField(10);

        // add the contents to the input panel
        inputPanel.add(adultPriceLabel);
        inputPanel.add(adultPriceText);
        inputPanel.add(adultSoldLabel);
        inputPanel.add(adultSoldText);
        inputPanel.add(childPriceLabel);
        inputPanel.add(childPriceText);
        inputPanel.add(childSoldLabel);
        inputPanel.add(childSoldText);
    }


    /**
     * Method to create the result panel
     */
    private void createResultPanel()
    {
        // Create the labels
        grossAdultRevenueLabel = new JLabel("Gross revenue for Adult tickets sold: ");
        netAdultRevenueLabel = new JLabel("Net revenue for Adult tickets sold: ");
        grossChildRevenueLabel = new JLabel("Gross revenue for Child tickets sold: " );
        netChildRevenueLabel = new JLabel("Net revenue for Child tickets sold: ");
        totalGrossRevenueLabel = new JLabel("Total gross revenue: " );
        totalNetRevenueLabel = new JLabel("Total net revenue: ");

        grossAdultRevenueResultLabel = new JLabel("-");
        netAdultRevenueResultLabel = new JLabel("-");
        grossChildRevenueResultLabel = new JLabel("-");
        netChildRevenueResultLabel = new JLabel("-");
        totalGrossRevenueResultLabel = new JLabel("-");
        totalNetRevenueResultLabel = new JLabel("-");

        // create the result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(6, 2));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Results"));

        // add the contents to the results panel
        resultPanel.add(grossAdultRevenueLabel);
        resultPanel.add(grossAdultRevenueResultLabel);
        resultPanel.add(netAdultRevenueLabel);
        resultPanel.add(netAdultRevenueResultLabel);
        resultPanel.add(grossChildRevenueLabel);
        resultPanel.add(grossChildRevenueResultLabel);
        resultPanel.add(netChildRevenueLabel);
        resultPanel.add(netChildRevenueResultLabel);
        resultPanel.add(totalGrossRevenueLabel);
        resultPanel.add(totalGrossRevenueResultLabel);
        resultPanel.add(totalNetRevenueLabel);
        resultPanel.add(totalNetRevenueResultLabel);
    }

    /**
     * Method to create the button panel
     */
    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        setLayout(new GridLayout(1, 2));

        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        // Register the event handlers
        calcButton.addActionListener(new CalculateButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);
    }


    /**
     * Private inner class used to calculate and display the businessman's
     * expense details
     */
    private class CalculateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Add the user input to variables any errors will return false
            if(!getUserInput())
                return;

            calculateGrossRevenues();
            calculateNetRevenues();

            displayResults();
        }

        /**
         * The method getUserInput adds the user input to the correct variables
         * @return Will return false if there were any errors in the user's data
         */
        private boolean getUserInput()
        {
            // validate the user input and add to the variables
            try {
                if(adultPriceText.getText().equals("")==false) {
                    adultPrice = Integer.parseInt(adultPriceText.getText());
                    if (adultPrice <= 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Adult-Ticket-Price value must be greater then zero!");
                        return false;
                    }
                }
                else adultPrice = 0.0F;
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Adult-Ticket-Price value can only be numerical!");
                adultPriceText.setText("");
                return false;
            }

            try {
                if(adultSoldText.getText().equals("")==false) {
                    adultSold = Integer.parseInt(adultSoldText.getText());
                    if (adultSold < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Adult-Tickets-Sold value must be zero or more!");
                        return false;
                    }
                }
                else adultSold = 0;
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Adult-Tickets-Sold value can only be numerical!");
                adultSoldText.setText("");
                return false;
            }

            try {
                if(childPriceText.getText().equals("")==false) {
                    childPrice = Integer.parseInt(childPriceText.getText());
                    if (childPrice <= 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Child-Ticket-Price value must be greater then zero!");
                        return false;
                    }
                }
                else childPrice = 0.0F;
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Child-Ticket-Price value can only be numerical!");
                childPriceText.setText("");
                return false;
            }

            try {
                if(childSoldText.getText().equals("")==false) {
                    childSold = Integer.parseInt(childSoldText.getText());
                    if (childSold < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Child-Tickets-Sold value must be zero or more!");
                        return false;
                    }
                }
                else childSold = 0;
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Child-Tickets-Sold value can only be numerical!");
                childSoldText.setText("");
                return false;
            }

            return true;
        }


        /**
         * This method calculates all of the gross revenues and assigns them
         * to their variables
         */
        private void calculateGrossRevenues()
        {
            grossAdultRevenue = adultPrice * adultSold;
            grossChildRevenue = childPrice * childSold;
            totalGrossRevenue = grossAdultRevenue + grossChildRevenue;
        }

        /**
         * This method calculates all of the net revenues and assigns them
         * to their variables
         */
        private void calculateNetRevenues()
        {
            netAdultRevenue = grossAdultRevenue * THEATRE_PERCENTAGE;
            netChildRevenue = grossChildRevenue * THEATRE_PERCENTAGE;
            totalNetRevenue = netAdultRevenue + netChildRevenue;
        }

        /**
         * Method to add the results to the result labels
         */
        private void displayResults()
        {
            DecimalFormat pounds = new DecimalFormat("#,##0.00");

            grossAdultRevenueResultLabel.setText("$" + pounds.format(grossAdultRevenue));
            netAdultRevenueResultLabel.setText("$" + pounds.format(netAdultRevenue));

            grossChildRevenueResultLabel.setText("$" + pounds.format(grossChildRevenue));
            netChildRevenueResultLabel.setText("$" + pounds.format(netChildRevenue));

            totalGrossRevenueResultLabel.setText("$" + pounds.format(totalGrossRevenue));
            totalNetRevenueResultLabel.setText("$" + pounds.format(totalNetRevenue));
        }

    }

    /**
     * Private inner class that closes the application when the exit button is pressed
     */
    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
