/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/10/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class InputAndResultsPanel extends JPanel
{

    // Constants for the result calculation
    private final int OIL_CHANGE = 26;
    private final int LUBE_JOB = 18;
    private final int RADIATOR_FLUSH = 30;
    private final int TRANSMISSION_FLUSH = 80;
    private final int INSPECTION = 15;
    private final int MUFFLER_REPLACEMENT = 100;
    private final int TYRE_ROTATION = 20;
    private final int LABOUR_PER_HOUR = 20;

    // Inner Panels
    private JPanel inputPanel;
        private JPanel checkboxPanel;
        private JPanel textboxPanel;

    private JPanel resultPanel;
    private JPanel buttonPanel;

    // Checkboxes
    private JCheckBox oilCheckbox;
    private JCheckBox lubeCheckbox;
    private JCheckBox radiatorCheckbox;
    private JCheckBox transmissionCheckbox;
    private JCheckBox inspectionCheckbox;
    private JCheckBox mufflerCheckbox;
    private JCheckBox tyreCheckbox;


    // Descriptive labels
    private JLabel costOfPartsLabel;
    private JLabel hoursWorkedLabel;
    private JLabel totalCostsLabel;

    // Text input box for the property value
    private JTextField costOfPartsText;
    private JTextField hoursWorkedText;

    // Action Buttons
    private JButton calcButton;
    private JButton exitButton;

    // Results label
    private JLabel totalCostsResultLabel;

    // Variables for holding the result
    private float totalCosts = 0.0F;


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


    private void createCheckboxPanel()
    {
        // Create the panel
        checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(7, 1));
        checkboxPanel.setBorder(BorderFactory.createTitledBorder("ROUTINE MAINTENANCE"));

        // Create the checkboxes
        oilCheckbox = new JCheckBox("Oil Change");
        lubeCheckbox = new JCheckBox("Lube Job");
        radiatorCheckbox = new JCheckBox("Radiator flush");
        transmissionCheckbox = new JCheckBox("Transmission flush");
        inspectionCheckbox = new JCheckBox("Inspection");
        mufflerCheckbox = new JCheckBox("Muffler replacement");
        tyreCheckbox = new JCheckBox("Tyre rotation");

        // Add the checkboxes
        checkboxPanel.add(oilCheckbox);
        checkboxPanel.add(lubeCheckbox);
        checkboxPanel.add(radiatorCheckbox);
        checkboxPanel.add(transmissionCheckbox);
        checkboxPanel.add(inspectionCheckbox);
        checkboxPanel.add(mufflerCheckbox);
        checkboxPanel.add(tyreCheckbox);
    }

    /**
     * This method creates the inner panel of the Input panel
     * that contains the textboxes for the non-routine services
     */
    private void createTextboxPanel()
    {
        textboxPanel = new JPanel();
        textboxPanel.setLayout(new GridLayout(2, 2));
        textboxPanel.setBorder(BorderFactory.createTitledBorder("NON-ROUTINE SERVICES"));

        // create the descriptive labels
        costOfPartsLabel = new JLabel("Cost of parts: ");
        hoursWorkedLabel = new JLabel("Hours worked: ");

        // create the text boxes
        costOfPartsText = new JTextField(10);
        hoursWorkedText = new JTextField(10);

        textboxPanel.add(costOfPartsLabel);
        textboxPanel.add(costOfPartsText);
        textboxPanel.add(hoursWorkedLabel);
        textboxPanel.add(hoursWorkedText);
    }

    /**
     * Method to create the input panel
     */
    private void createInputPanel()
    {
        // create the input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        // create the inner panels
        createCheckboxPanel();
        createTextboxPanel();

        // add the contents to the input panel
        inputPanel.add(checkboxPanel, BorderLayout.NORTH);
        inputPanel.add(textboxPanel, BorderLayout.SOUTH);
    }


    /**
     * Method to create the result panel
     */
    private void createResultPanel()
    {
        // Create the labels
        totalCostsLabel = new JLabel(" ");

        totalCostsResultLabel = new JLabel("-");

        // create the result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 2));
        resultPanel.setBorder(BorderFactory.createTitledBorder("TOTAL COSTS"));

        // add the contents to the results panel
        resultPanel.add(totalCostsLabel);
        resultPanel.add(totalCostsResultLabel);
    }

    /**
     * Method to create the button panel
     */
    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

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

            displayResults();
        }

        /**
         * The method getUserInput adds the costs incurred to the total costs
         * @return Will return false if there were any errors in the user's data
         */
        private boolean getUserInput()
        {
            float costOfParts = 0.0F;
            float hoursWorked = 0.0F;
            totalCosts = 0.0F;

            // validate the user input and add to the variables
            try {
                if (costOfPartsText.getText().equals("") == false) {
                    costOfParts = Float.parseFloat(costOfPartsText.getText());
                    if (costOfParts < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Cost-Of-Parts value must be greater then zero!");
                        return false;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error - The Cost-Of-Parts value can only be numerical!");
                costOfPartsText.setText("");
                return false;
            }

            totalCosts += costOfParts;

            try {
                if (hoursWorkedText.getText().equals("") == false) {
                    hoursWorked = Float.parseFloat(hoursWorkedText.getText());
                    if (hoursWorked < 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Hours-Worked value must be greater then zero!");
                        return false;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error - The Hours-Worked value can only be numerical!");
                hoursWorkedText.setText("");
                return false;
            }

            // If parts have been added to the total then a minimum of 1 hour is charged
            if (costOfParts > 0 && hoursWorked == 0) {
                hoursWorked = 1.0F;
                hoursWorkedText.setText("1");
            }
            totalCosts += hoursWorked * LABOUR_PER_HOUR;

            // Add costs for the selected checkboxes
            if(oilCheckbox.isSelected())
                totalCosts += OIL_CHANGE;
            if(lubeCheckbox.isSelected())
                totalCosts += LUBE_JOB;
            if(radiatorCheckbox.isSelected())
                totalCosts += RADIATOR_FLUSH;
            if(transmissionCheckbox.isSelected())
                totalCosts += TRANSMISSION_FLUSH;
            if(inspectionCheckbox.isSelected())
                totalCosts+= INSPECTION;
            if(mufflerCheckbox.isSelected())
                totalCosts += MUFFLER_REPLACEMENT;
            if(tyreCheckbox.isSelected())
                totalCosts += TYRE_ROTATION;

            return true;
        }


        /**
         * Method to add the results to the result labels
         */
        private void displayResults()
        {
            DecimalFormat pounds = new DecimalFormat("#,##0.00");

            totalCostsResultLabel.setText("$" + pounds.format(totalCosts));
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

