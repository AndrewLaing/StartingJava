/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class InputAndResultsPanel extends JPanel
{
    // Constants for the tax rates
    private final float CTR = 0.02F;    // County tax rate of 2%
    private final float STR = 0.04F;    // State tax rate of 4%


    // Descriptive labels
    private JLabel entryLabel;
    private JLabel countyLabel;
    private JLabel stateLabel;
    private JLabel totalLabel;

    // Text input box
    private JTextField totalSalesText;

    // Results labels
    private JLabel cstResult;       // to hold the result for the county sales tax
    private JLabel sstResult;       // to hold the result for the state sales tax
    private JLabel totalResult;     // to hold the result for the total sales tax

    // Action Buttons
    private JButton calcButton;
    private JButton exitButton;

    // Inner Panels
    private JPanel inputPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;


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
     * The createInputPanel method creates the input panel
     */
    private void createInputPanel()
    {
        // create the input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter data"));

        entryLabel = new JLabel("Total sales for the month in pounds: ");     // Create the label
        totalSalesText = new JTextField(10);                        // Create the text box

        // add the contents to the input panel
        inputPanel.add(entryLabel);
        inputPanel.add(totalSalesText);
    }


    /**
     * The createResultPanel method creates the result panel
     */
    private void createResultPanel()
    {
        // Create the labels
        countyLabel = new JLabel("County sales tax: ");
        stateLabel = new JLabel( "State sales tax:  ");
        totalLabel = new JLabel( "Total sales tax:  ");

        cstResult = new JLabel("-");
        sstResult = new JLabel("-");
        totalResult = new JLabel("-");

        // create the result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(3, 2));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Calculate taxes due"));

        // add the contents to the results panel
        resultPanel.add(countyLabel);
        resultPanel.add(cstResult);
        resultPanel.add(stateLabel);
        resultPanel.add(sstResult);
        resultPanel.add(totalLabel);
        resultPanel.add(totalResult);
    }

    /**
     * The createButtonPanel method creates the button panel
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


    private class CalculateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DecimalFormat pounds = new DecimalFormat("#,##0.00");
            float totalMonthlySales = 0.0F;     // to hold the total monthly sales figure
            float calculatedCountyTax;          // to hold the results
            float calculatedStateTax;           //   "  "  "  "  "  "
            float calculatedTotalTax;           //   "  "  "  "  "  "

            String userInput = totalSalesText.getText();  // to hold the users input

            // validate the user input
            if(userInput.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Error - The Monthly Sales field must be completed");
                return;
            }

            try {
                totalMonthlySales = Float.parseFloat(userInput);
            }
            catch (NumberFormatException ex )
            {
                JOptionPane.showMessageDialog(null, "Error - The Monthly Sales field can only a valid monetary sum");
                totalSalesText.setText("");
                return;
            }

            if(totalMonthlySales <= 0)
            {
                JOptionPane.showMessageDialog(null, "Error - The Monthly Sales must be greater then zero!");
                return;
            }

            // Calculate and display the results
            calculatedCountyTax = totalMonthlySales * CTR;
            calculatedStateTax = totalMonthlySales * STR;
            calculatedTotalTax = calculatedCountyTax + calculatedStateTax;

            cstResult.setText("$" + pounds.format(calculatedCountyTax));
            sstResult.setText("$" + pounds.format(calculatedStateTax));
            totalResult.setText("$" + pounds.format(calculatedTotalTax));
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
