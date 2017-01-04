/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/10/2016.
 */

import javax.swing.*;
import java.awt.*;


public class JoesAutomotiveGUI extends JFrame
{
    /**
     * Constructor
     */
    public JoesAutomotiveGUI()
    {
        GreetingPanel banner = new GreetingPanel();
        InputAndResultsPanel input = new InputAndResultsPanel();

        setTitle("Challenge 6");
        setLayout(new BorderLayout());
        setResizable(false);

        add(banner, BorderLayout.NORTH);
        add(input, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
