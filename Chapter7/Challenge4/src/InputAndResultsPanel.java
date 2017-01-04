/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class InputAndResultsPanel extends JPanel
{

    // Constants for the result calculation
    private final float MAX_MEALS = 37.0F;          // Maximum daily meals allowance
    private final float MAX_PARKING = 10.00F;       // Maximum daily parking allowance
    private final float MAX_TAXI_CHARGES = 20.0F;   // Maximum daily taxi charges allowance
    private final float MAX_LODGINGS_PAID = 95.0F;  // Maximum daily meals allowance
    private final float REIMBURSED_MILEAGE = 0.27F; // Mileage for private vehicles is reimbursed at 27c per mile

    // Inner Panels
    private JPanel inputPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    // Descriptive labels
    private JLabel daysOnTripLabel;
    private JLabel airfareCostsLabel;
    private JLabel carRentalFeesLabel;
    private JLabel milesDrivenLabel;
    private JLabel parkingFeesLabel;
    private JLabel taxiChargesLabel;
    private JLabel registrationFeesLabel;
    private JLabel lodgingCostsLabel;
    private JLabel mealCostsLabel;
    private JLabel totalIncurredLabel;
    private JLabel totalAllowedLabel;
    private JLabel excessDueLabel;
    private JLabel amountSavedLabel;

    // Results labels
    private JLabel totalIncurredResultLabel;
    private JLabel totalAllowedResultLabel;
    private JLabel excessDueResultLabel;
    private JLabel amountSavedResultLabel;

    // Text input box for the property value
    private JTextField propertyValText;

    private JTextField daysOnTripText;
    private JTextField airfareCostsText;
    private JTextField carRentalFeesText;
    private JTextField milesDrivenText;
    private JTextField parkingFeesText;
    private JTextField taxiChargesText;
    private JTextField registrationFeesText;
    private JTextField lodgingCostsText;
    private JTextField mealCostsText;

    // Action Buttons
    private JButton calcButton;
    private JButton exitButton;

    // Variables for holding user input
    private int daysOnTrip = 0;
    private float airfareCosts = 0.0F;
    private float carRentalFees = 0.0F;
    private float milesDriven = 0.0F;
    private float parkingFees = 0.0F;
    private float taxiCharges = 0.0F;
    private float registrationFees = 0.0F;
    private float lodgingCosts = 0.0F;
    private float mealCosts = 0.0F;


    // Variables for holding results
    private float totalIncurred = 0.0F;
    private float totalAllowed = 0.0F;
    private float excessDue = 0.0F;
    private float amountSaved = 0.0F;


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
        inputPanel.setLayout(new GridLayout(9, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter data"));

        // create the descriptive labels
        daysOnTripLabel = new JLabel("Number of days on trip: ");
        airfareCostsLabel = new JLabel("Cost of Airfare: ");
        carRentalFeesLabel = new JLabel("Car rental fees: ");
        milesDrivenLabel = new JLabel("Miles driven (if private vehicle used): ");
        parkingFeesLabel = new JLabel("Parking Expenses: ");
        taxiChargesLabel = new JLabel("Taxi Charges: ");
        registrationFeesLabel = new JLabel("Conference/Seminar registration fees: ");
        lodgingCostsLabel = new JLabel("Lodging costs per night: ");
        mealCostsLabel = new JLabel("Meal Expenses: ");

        // create the text boxes
        daysOnTripText = new JTextField(10);
        airfareCostsText = new JTextField(10);
        carRentalFeesText = new JTextField(10);
        milesDrivenText = new JTextField(10);
        parkingFeesText = new JTextField(10);
        taxiChargesText = new JTextField(10);
        registrationFeesText = new JTextField(10);
        lodgingCostsText = new JTextField(10);
        mealCostsText = new JTextField(10);

        // add the contents to the input panel
        inputPanel.add(daysOnTripLabel);
        inputPanel.add(daysOnTripText);
        inputPanel.add(airfareCostsLabel);
        inputPanel.add(airfareCostsText);
        inputPanel.add(carRentalFeesLabel);
        inputPanel.add(carRentalFeesText);
        inputPanel.add(milesDrivenLabel);
        inputPanel.add(milesDrivenText);
        inputPanel.add(parkingFeesLabel);
        inputPanel.add(parkingFeesText);
        inputPanel.add(taxiChargesLabel);
        inputPanel.add(taxiChargesText);
        inputPanel.add(registrationFeesLabel);
        inputPanel.add(registrationFeesText);
        inputPanel.add(lodgingCostsLabel);
        inputPanel.add(lodgingCostsText);
        inputPanel.add(mealCostsLabel);
        inputPanel.add(mealCostsText);
    }


    /**
     * Method to create the result panel
     */
    private void createResultPanel()
    {
        // Create the labels
        totalIncurredLabel = new JLabel("Total expenses incurred: ");
        totalAllowedLabel = new JLabel("Total allowable expenses: ");
        excessDueLabel = new JLabel("Excess amount to be paid: " );
        amountSavedLabel = new JLabel("Amount saved: ");

        totalIncurredResultLabel = new JLabel("-");
        totalAllowedResultLabel = new JLabel("-");
        excessDueResultLabel = new JLabel("-");
        amountSavedResultLabel = new JLabel("-");

        // create the result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(4, 2));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Results"));

        // add the contents to the results panel
        resultPanel.add(totalIncurredLabel);
        resultPanel.add(totalIncurredResultLabel);
        resultPanel.add(totalAllowedLabel);
        resultPanel.add(totalAllowedResultLabel);
        resultPanel.add(excessDueLabel);
        resultPanel.add(excessDueResultLabel);
        resultPanel.add(amountSavedLabel);
        resultPanel.add(amountSavedResultLabel);
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

            calculateTotalIncurred();
            calculateExcessDue();
            calculateAmountSaved();
            calculateTotalAllowed();

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
                if(daysOnTripText.getText().equals("")==false) {
                    daysOnTrip = Integer.parseInt(daysOnTripText.getText());
                    if (daysOnTrip <= 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Days-On-Trip value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Days-On-Trip value can only be numerical!");
                daysOnTripText.setText("");
                return false;
            }

            try {
                if(airfareCostsText.getText().equals("")==false) {
                    airfareCosts = Float.parseFloat(airfareCostsText.getText());
                    if (airfareCosts < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Airfare-Costs value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Airfare-Costs value can only be numerical!");
                airfareCostsText.setText("");
                return false;
            }

            try {
                if(carRentalFeesText.getText().equals("")==false) {
                    carRentalFees = Float.parseFloat(carRentalFeesText.getText());
                    if (carRentalFees < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Car-Rental-Fees value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Car-Rental-Fees value can only be numerical!");
                carRentalFeesText.setText("");
                return false;
            }

            try {
                if(milesDrivenText.getText().equals("")==false) {
                    milesDriven = Float.parseFloat(milesDrivenText.getText());
                    if (milesDriven < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Miles-Driven value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Miles-Driven value can only be numerical!");
                milesDrivenText.setText("");
                return false;
            }

            try {
                if(parkingFeesText.getText().equals("")==false) {
                    parkingFees = Float.parseFloat(parkingFeesText.getText());
                    if (parkingFees < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Parking-Expenses value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Parking-Expenses value can only be numerical!");
                parkingFeesText.setText("");
                return false;
            }

            try {
                if(taxiChargesText.getText().equals("")==false) {
                    taxiCharges = Float.parseFloat(taxiChargesText.getText());
                    if (taxiCharges < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Taxi-Charges value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Taxi-Charges value can only be numerical!");
                taxiChargesText.setText("");
                return false;
            }

            try {
                if(registrationFeesText.getText().equals("")==false) {
                    registrationFees = Float.parseFloat(registrationFeesText.getText());
                    if (registrationFees < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Registration-Fees value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Registration-Fees value can only be numerical!");
                registrationFeesText.setText("");
                return false;
            }

            try {
                if(lodgingCostsText.getText().equals("")==false) {
                    lodgingCosts = Float.parseFloat(lodgingCostsText.getText());
                    if (lodgingCosts < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Lodging-Costs value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Lodging-Costs value can only be numerical!");
                lodgingCostsText.setText("");
                return false;
            }


            try {
                if(mealCostsText.getText().equals("")==false) {
                    mealCosts = Float.parseFloat(mealCostsText.getText());
                    if (mealCosts < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Meal-Expenses value must be greater then zero!");
                        return false;
                    }
                }
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Meal-Expenses value can only be numerical!");
                mealCostsText.setText("");
                return false;
            }


            return true;
        }

        /**
         * Method to calculate the total expenses of the businessman
         */
        private void calculateTotalIncurred()
        {
            totalIncurred = 0.0F;

            totalIncurred += airfareCosts;
            totalIncurred += carRentalFees;

            // Mileage is only reimbursed for private vehicles not rentals
            if(carRentalFees == 0 && milesDriven > 0)
                totalIncurred += milesDriven * REIMBURSED_MILEAGE;

            totalIncurred += parkingFees;
            totalIncurred += taxiCharges;
            totalIncurred += registrationFees;
            totalIncurred += daysOnTrip * lodgingCosts;
            totalIncurred += mealCosts;
        }

        /**
         * Method to calculate the total allowed expenses of the businessman
         */
        private void calculateTotalAllowed()
        {
            totalAllowed = totalIncurred - excessDue + amountSaved;
        }

        /**
         * Method to calculate how much the businessman overspent on the trip
         */
        private void calculateExcessDue()
        {
            float difference = 0.0F;
            excessDue = 0.0F;

            difference = parkingFees - (MAX_PARKING * daysOnTrip);
            if(difference > 0)
                excessDue += difference;

            difference = taxiCharges - (MAX_TAXI_CHARGES * daysOnTrip);
            if(difference > 0)
                excessDue += difference;

            difference = (lodgingCosts * daysOnTrip) - (MAX_LODGINGS_PAID * daysOnTrip);
            if(difference > 0)
                excessDue += difference;

            difference = mealCosts - (MAX_MEALS * daysOnTrip);
            if(difference > 0)
                excessDue += difference;

        }

        /**
         * Method to calculate the amount that the businessman spent under the amount allowed
         */
        private void calculateAmountSaved()
        {
            float difference = 0.0F;
            amountSaved = 0.0F;

            difference = (MAX_PARKING * daysOnTrip) - parkingFees;
            if(difference > 0)
                amountSaved += difference;

            difference = (MAX_TAXI_CHARGES * daysOnTrip) - taxiCharges;
            if(difference > 0)
                amountSaved += difference;

            difference = (MAX_LODGINGS_PAID * daysOnTrip) - (lodgingCosts * daysOnTrip);
            if(difference > 0)
                amountSaved += difference;

            difference = (MAX_MEALS * daysOnTrip) - mealCosts;
            if(difference > 0)
                amountSaved += difference;

        }

        /**
         * Method to add the results to the result labels
         */
        private void displayResults()
        {
            DecimalFormat pounds = new DecimalFormat("#,##0.00");

            totalIncurredResultLabel.setText("$" + pounds.format(totalIncurred));
            totalAllowedResultLabel.setText("$" + pounds.format(totalAllowed));

            if(totalIncurred > totalAllowed)
            {
                excessDueResultLabel.setText("$" + pounds.format(totalIncurred - totalAllowed));
                amountSavedResultLabel.setText("$0.00");
            }
            else
            {
                excessDueResultLabel.setText("$0.00");
                amountSavedResultLabel.setText("$" + pounds.format(totalAllowed - totalIncurred) );
            }
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
