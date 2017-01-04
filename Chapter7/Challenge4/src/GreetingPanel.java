/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/10/2016.
 */

import javax.swing.*;
import java.awt.*;

/**
 * The GreetingPanel class creates a panel with a greeting
 * banner inside of it and a descriptive text for the user
 */
public class GreetingPanel extends JPanel
{
    private JLabel greeting;   // to display a greeting
    private JLabel padding;    // to add a space between the two labels
    private JLabel message;    // to display a descriptive text for the user

    // Constructor
    public GreetingPanel()
    {
        // Create the label
        setLayout(new BorderLayout());
        greeting = new JLabel("Travel Expenses Calculator");
        padding = new JLabel(" ");
        message = new JLabel("Please fill in all of the applicable fields " +
                             "and leave all other fields empty.");

        // add the label to this panel
        add(greeting, BorderLayout.NORTH);
        add(message, BorderLayout.CENTER);
        add(padding, BorderLayout.SOUTH);

    }
}