/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   26/10/2016.
 */

import javax.swing.*;
import java.awt.*;

public class TheatreRevenueGUI extends JFrame
{
    public TheatreRevenueGUI()
    {
        GreetingPanel banner = new GreetingPanel();
        InputAndResultsPanel input = new InputAndResultsPanel();

        setTitle("Challenge 5");
        setLayout(new BorderLayout());

        add(banner, BorderLayout.NORTH);
        add(input, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
