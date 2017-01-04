/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/11/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TestGUI extends JFrame
{
    public TestGUI() throws IOException
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

        // get the title from InputPanel to add here
        banner.setGreeting(input.getNameOfTest());

        paddingPanel.add(banner, BorderLayout.NORTH);
        paddingPanel.add(input, BorderLayout.CENTER);

        add(paddingPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(940,270);
        //pack();

    }
}
