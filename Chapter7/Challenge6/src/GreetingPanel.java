/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/10/2016.
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
        setBorder(BorderFactory.createEmptyBorder(10,0,5,0));

        greeting = new JLabel("   JOE'S AUTOMOTIVE   ");
        greeting.setFont(new Font("Sans", Font.PLAIN, 24));
        greeting.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        add(greeting, BorderLayout.CENTER);
    }
}