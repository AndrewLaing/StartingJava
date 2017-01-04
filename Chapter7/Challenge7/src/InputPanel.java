/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   28/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class InputPanel extends JPanel
{
    // Constants for the call rates per minute
    private final float DAYTIME_RATE = 0.07F;
    private final float EVENING_RATE = 0.12F;
    private final float OFFPEAK_RATE = 0.05F;

    // Inner Panels
    private JPanel radioButtonPanel;
    private JPanel textboxPanel;
    private JPanel buttonPanel;

    // Action Buttons
    private JButton calcButton;
    private JButton exitButton;

    // Descriptive Labels
    private JLabel categoriesLabel;
    private JLabel ratesLabel;
    private JLabel daytimeRateLabel;
    private JLabel eveningRateLabel;
    private JLabel offpeakRateLabel;
    private JLabel callLengthLabel;

    // Radiobuttons
    private ButtonGroup radioButtonGroup;
    private JRadioButton daytimeRadioBtn;
    private JRadioButton eveningRadioBtn;
    private JRadioButton offpeakRadioBtn;

    // Text box
    private JTextField callLengthText;


    /**
     * Constructor
     */
    public InputPanel()
    {
        createRadioButtonPanel();
        createTextboxPanel();
        createButtonPanel();

        setLayout(new BorderLayout());

        // add the panels to the InputAndResults Panel
        add(radioButtonPanel, BorderLayout.NORTH);
        add(textboxPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createRadioButtonPanel()
    {
        // Create the panel
        radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(4, 2));
        radioButtonPanel.setBorder(BorderFactory.createTitledBorder("CHOOSE A RATE CATEGORY"));

        // Create the labels
        categoriesLabel = new JLabel("Rate Category", CENTER);
        ratesLabel = new JLabel("Rate per minute", CENTER);
        daytimeRateLabel = new JLabel("$0.07", CENTER);
        eveningRateLabel = new JLabel("$0.12", CENTER);
        offpeakRateLabel = new JLabel("$0.05", CENTER);

        // Create the radio buttons
        radioButtonGroup = new ButtonGroup();
        daytimeRadioBtn = new JRadioButton("DAYTIME ( 6:00am through  5:59pm)", true); // default selected button
        eveningRadioBtn = new JRadioButton("EVENING ( 6:00pm through 11:59pm)");
        offpeakRadioBtn = new JRadioButton("OFFPEAK (12:00am through  5:59am)");

        // Group the radio buttons together
        radioButtonGroup.add(daytimeRadioBtn);
        radioButtonGroup.add(eveningRadioBtn);
        radioButtonGroup.add(offpeakRadioBtn);

        radioButtonPanel.add(categoriesLabel);
        radioButtonPanel.add(ratesLabel);
        radioButtonPanel.add(daytimeRadioBtn);
        radioButtonPanel.add(daytimeRateLabel);
        radioButtonPanel.add(eveningRadioBtn);
        radioButtonPanel.add(eveningRateLabel);
        radioButtonPanel.add(offpeakRadioBtn);
        radioButtonPanel.add(offpeakRateLabel);
    }

    private void createTextboxPanel()
    {
        textboxPanel = new JPanel();
        textboxPanel.setLayout(new FlowLayout());
        textboxPanel.setBorder(BorderFactory.createTitledBorder("ENTER LENGTH OF CALL"));

        // create the descriptive labels
        callLengthLabel = new JLabel("Length of call in minutes:                              ", RIGHT);

        // create the text boxes
        callLengthText = new JTextField(3);
        callLengthText.setText("0");
        callLengthText.setHorizontalAlignment(CENTER);

        // Add the items to the Panel
        textboxPanel.add(callLengthLabel);
        textboxPanel.add(callLengthText);
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
            // Calculate the charge due
            DecimalFormat pounds = new DecimalFormat("#,##0.00");
            float callLength = 0.0F;
            float costOfCall;
            String charge;

            charge = "The cost of your call is $";

            // validate the user input and add to the variables
            try {
                if (callLengthText.getText().equals("") == false) {
                    callLength = Float.parseFloat(callLengthText.getText());
                    if (callLength <= 0) {
                        JOptionPane.showMessageDialog(null, "Error - The Call-Length value must be greater then zero!");
                        return;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error - The Call-Length value can only be numerical!");
                callLengthText.setText("");
                return;
            }

            // Calculate the cost of the call
            if(daytimeRadioBtn.isSelected())
                costOfCall = DAYTIME_RATE * callLength;
            else if(eveningRadioBtn.isSelected())
                costOfCall = EVENING_RATE * callLength;
            else
                costOfCall = OFFPEAK_RATE * callLength;

            charge += pounds.format(costOfCall);
            // Display the charge to the user
            JOptionPane.showMessageDialog(null, charge);
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
