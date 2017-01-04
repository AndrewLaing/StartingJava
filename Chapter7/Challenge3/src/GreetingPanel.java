/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/10/2016.
 */

import javax.swing.*;

/**
 * The GreetingPanel class creates a panel with a greeting
 * banner inside of it
 */
public class GreetingPanel extends JPanel
{
    private JLabel greeting;   // to display a greeting

    // Constructor
    public GreetingPanel()
    {
        // Create the label
        greeting = new JLabel("Property Tax Calculator");

        // add the label to this panel
        add(greeting);
    }
}
