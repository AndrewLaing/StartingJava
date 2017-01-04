/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/10/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalesTaxGUIPanel extends JFrame
{
    public SalesTaxGUIPanel()
    {
        GreetingPanel banner = new GreetingPanel();
        InputAndResultsPanel input = new InputAndResultsPanel();

        setTitle("Challenge 2");
        setLayout(new BorderLayout());

        add(banner, BorderLayout.NORTH);
        add(input, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
