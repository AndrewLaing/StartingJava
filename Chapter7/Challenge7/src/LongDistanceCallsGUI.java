/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   28/10/2016.
 */

import javax.swing.*;
import java.awt.*;

public class LongDistanceCallsGUI extends JFrame
{
    public LongDistanceCallsGUI()
    {
        GreetingPanel banner = new GreetingPanel();
        InputPanel input = new InputPanel();

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        setTitle("Challenge 7");
        setLayout(new BorderLayout());
        setResizable(false);

        paddingPanel.add(banner, BorderLayout.NORTH);
        paddingPanel.add(input, BorderLayout.CENTER);

        add(paddingPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
