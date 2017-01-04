/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PropertyTaxGUI extends JFrame
{
    public PropertyTaxGUI()
    {
        GreetingPanel banner = new GreetingPanel();
        InputAndResultsPanel input = new InputAndResultsPanel();

        setTitle("Challenge 3");
        setLayout(new BorderLayout());

        add(banner, BorderLayout.NORTH);
        add(input, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
