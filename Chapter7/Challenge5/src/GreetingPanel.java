/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   26/10/2016.
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
    private JLabel padding;    // to add a space at the bottom of the Panel

    // Constructor
    public GreetingPanel()
    {
        // Create the label
        setLayout(new BorderLayout());
        greeting = new JLabel("Theatre Revenue Calculator");
        padding = new JLabel(" ");

        // add the label to this panel
        add(greeting, BorderLayout.NORTH);
        add(padding, BorderLayout.SOUTH);

    }
}
