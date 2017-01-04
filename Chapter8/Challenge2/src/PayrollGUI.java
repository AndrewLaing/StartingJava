/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   09/11/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PayrollGUI extends JFrame
{
    // GUI elements
    private JPanel paddingPanel; // used to put padding around the panels in the content pane
    private GreetingPanel banner;
    private InputPanel userInput;
    private JPanel buttonPanel;
    private JButton nextButton;

    // Create the arrays to hold the employee details
    private final int EMPLOYEES = 7;
    private final int[] employeeIDs = {5658845, 4520125, 7895122, 8777541,
                                       8451277, 1302850, 7580489 };

    private final double[] hours = new double[EMPLOYEES];
    private final double[] payRate = new double[EMPLOYEES];
    private final double[] wages = new double[EMPLOYEES];

    private int currentIndex = 0;   // to hold the index of the record currently being worked on


    public PayrollGUI()
    {
        // create the panels to be added to the window
        banner = new GreetingPanel();
        userInput = new InputPanel(employeeIDs[0]);
        buttonPanel = new JPanel();

        // set the title of the window
        setTitle("Challenge 2");

        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a padding panel so that the content pane can put space around the added panels
        paddingPanel = new JPanel();
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        paddingPanel.setLayout(new BorderLayout());
        add(paddingPanel);

        // add the contents to the button panel
        makeButtonPanel();

        // Add the panels to the padding panel
        paddingPanel.add(banner, BorderLayout.NORTH);
        paddingPanel.add(userInput, BorderLayout.CENTER);
        paddingPanel.add(buttonPanel, BorderLayout.SOUTH);

        // display the window
        setVisible(true);
        pack();
    }

    private double getEmployeeWages(int IDNumber)
    {
        for(int i=0; i<EMPLOYEES; i++)
        {
            if(employeeIDs[i]==IDNumber)
                return wages[i];
        }

        return 0.0;
    }

    public void makeButtonPanel()
    {
        JLabel pad1 = new JLabel(" ");
        JLabel pad2 = new JLabel(" ");
        // set a GridLayout for the panel so the buttons will be the same size
        buttonPanel.setLayout(new GridLayout(1, 3));

        // create the buttons and attach the event listeners
        nextButton = new JButton("Next");

        // Register the event handlers
        nextButton.addActionListener(new NextButtonListener());

        // add the buttons to the panel
        buttonPanel.add(pad1);
        buttonPanel.add(pad2);
        buttonPanel.add(nextButton);

    }

    /**
     * Action listener used by the next button
     */
    private class NextButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // If the text fields contain valid values add them to the employees
            // record, add their calculated wages, then clear the text fields
            if(validHoursAdded() && validPayRateAdded())
            {
                addWages();
                currentIndex++;
                userInput.resetTextFieldTexts();
            }
            else
                return;

            if(currentIndex == EMPLOYEES)
            {
                DecimalFormat dollars = new DecimalFormat("#,##0.00");
                // create a list of the employees wages and display it then quit the application
                String result = " \nEmployee ID    Wages\n";

                for(int i=0; i<EMPLOYEES; i++)
                {
                    result += "\n" + Integer.toString( employeeIDs[i] ) + "           $";
                    result += dollars.format( getEmployeeWages(employeeIDs[i])  );
                }

                JOptionPane.showMessageDialog(null, result);
                System.exit(0);
            }
            else
                userInput.setEmployeeIDContentsLabelText(employeeIDs[currentIndex]);


        }

        // if the hours text box contains valid hours add them to the employees record
        private boolean validHoursAdded()
        {
            String temp = userInput.getHoursTextFieldText();
            double empHours = 0.0;

            try {
                empHours = Double.parseDouble(temp);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error - invalid input in hours field");
                userInput.resetHoursTextFieldText();
                return false;
            }

            if (empHours < 0) {
                JOptionPane.showMessageDialog(null, "Error - hours field must be completed with a positive number.");
                userInput.resetHoursTextFieldText();
                return false;
            }

            hours[currentIndex] = empHours;
            return true;
        }

        // if the pay rate text box contains a valid pay rate add it to the employees record
        private boolean validPayRateAdded()
        {
            String temp = userInput.getPayRateTextFieldText();
            double empPayRate = 0.0;

            try {
                empPayRate = Double.parseDouble(temp);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error - invalid input in Pay Rate field");
                userInput.resetPayRateTextFieldText();
                return false;
            }

            if (empPayRate < 6.0) {
                JOptionPane.showMessageDialog(null, "Error - Pay Rate field must be completed with a positive number greater than or equal to 6.00.");
                userInput.resetPayRateTextFieldText();
                return false;
            }

            payRate[currentIndex] = empPayRate;
            return true;
        }

        // calculate and add the wages to the employees record
        private void addWages()
        {
            wages[currentIndex] = hours[currentIndex] * payRate[currentIndex];
        }
    }
}
