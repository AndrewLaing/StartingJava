/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/10/2016.
 */

import javax.swing.*;
import java.awt.*;

public class TravelExpensesGUI extends JFrame
{
    /**
     * Constructor
     */
    public TravelExpensesGUI()
    {
        GreetingPanel banner = new GreetingPanel();
        InputAndResultsPanel input = new InputAndResultsPanel();

        setTitle("Challenge 4");
        setLayout(new BorderLayout());

        add(banner, BorderLayout.NORTH);
        add(input, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
