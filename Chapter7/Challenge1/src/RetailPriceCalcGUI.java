/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The RetailPriceCalcGUI class creates and displays the application
 */
public class RetailPriceCalcGUI extends JFrame
{
    private JPanel paddingPanel; // used to put padding around the panels in the content pane

    private GreetingPanel banner;
    private TextEntryPanel userInput;

    private JPanel buttonPanel;
    private JButton calcButton;
    private JButton exitButton;


    /**
     * Constructor
     */
    public RetailPriceCalcGUI()
    {
        // create the panels to be added to the window
        banner = new GreetingPanel();
        userInput = new TextEntryPanel();
        buttonPanel = new JPanel();

        // set the title of the window
        setTitle("Challenge 1");

        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a padding panel so that the content pane can put space
        //  around the added panels
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

    /**
     * The makeButtonPanel method adds contents to the button panel
     */
    public void makeButtonPanel()
    {
        // set a GridLayout for the panel so the buttons will be the same size
        buttonPanel.setLayout(new GridLayout(1, 2));

        // create the buttons and attach the event listeners
        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        // Register the event handlers
        calcButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // add the buttons to the panel
        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);
    }

    /**
     * Action listener used by the calculate button
     */
    private class CalcButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           userInput.displayRetailPrice();
        }
    }

    /**
     * Action listener used by the Exit button
     */
    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
