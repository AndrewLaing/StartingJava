/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   28/10/2016.
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

    // Constructor
    public GreetingPanel()
    {
        // Create the label
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5,0,10,0));

        greeting = new JLabel("   Long Distance Calls   ");
        greeting.setFont(new Font("Sans", Font.PLAIN, 20));
        greeting.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        add(greeting, BorderLayout.CENTER);
    }
}