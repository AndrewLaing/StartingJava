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
    private final float AV = 0.6F;      // Percentage of the property value to be assessed
    private final float PTR = 0.0064F;  // Property rate of $0.64 per $100 of assessment value

    // Inner Panels
    private JPanel inputPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    // Descriptive labels
    private JLabel entryLabel;
    private JLabel assessmentLabel;
    private JLabel propertyTaxLabel;

    // Results labels
    private JLabel assValResult;        // to hold the result for the calculated assessment value
    private JLabel propTaxResult;       // to hold the result for the calculated property tax

    // Text input box for the property value
    private JTextField propertyValText;

    // Action Buttons
    private JButton calcButton;
    private JButton exitButton;


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

    private void createInputPanel()
    {
        // create the input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter data"));

        entryLabel = new JLabel("Enter the property value in pounds: ");    // Create the label
        propertyValText = new JTextField(10);                               // Create the text box

        // add the contents to the input panel
        inputPanel.add(entryLabel);
        inputPanel.add(propertyValText);
    }

    private void createResultPanel()
    {
        // Create the labels
        assessmentLabel = new JLabel( "County sales tax: ");
        propertyTaxLabel = new JLabel("State sales tax:  ");

        assValResult = new JLabel("-");
        propTaxResult = new JLabel("-");

        // create the result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 2));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Calculated tax"));

        // add the contents to the results panel
        resultPanel.add(assessmentLabel);
        resultPanel.add(assValResult);
        resultPanel.add(propertyTaxLabel);
        resultPanel.add(propTaxResult);
    }

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


    private class CalculateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DecimalFormat pounds = new DecimalFormat("#,##0.00");
            float propertyValue = 0.0F;     // to hold the total monthly sales figure
            float assessmentValue;          // to hold the results
            float propertyTax;              //   "  "  "  "  "  "

            String userInput = propertyValText.getText();  // to hold the users input

            // validate the user input
            if(userInput.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Error - The Property Value field must be completed");
                return;
            }

            try {
                propertyValue = Float.parseFloat(userInput);
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Property Value field can only a valid monetary sum");
                propertyValText.setText("");
                return;
            }

            if(propertyValue <= 0)
            {
                JOptionPane.showMessageDialog(null, "Error - The Property Value must be greater then zero!");
                return;
            }

            // Calculate and display the results
            assessmentValue = propertyValue * AV;
            propertyTax = assessmentValue * PTR;

            assValResult.setText("$" + pounds.format(assessmentValue));
            propTaxResult.setText("$" + pounds.format(propertyTax));
        }
    }


    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
