/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/02/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StringDequeGUI extends JFrame
{
    // Reference to a StringDeque instance
    private StringDeque deque;

    // GUI Panels

    private JTextArea StringDequeView;
    private JTextField cmdTextfield;


    public StringDequeGUI()
    {
        // Create a WeddingLottery object
        deque = new StringDeque();

        setTitle("Challenge 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // create the inner components
        // Create the text area and add it to a Scroll Pane
        StringDequeView = new JTextArea(10, 1);
        StringDequeView.setEditable(false);

        StringDequeView.setText("The deque will be displayed here");
        JScrollPane scroll = new JScrollPane(StringDequeView);

        cmdTextfield = new JTextField(30);
        cmdTextfield.addActionListener(new CmdTextListener());

        paddingPanel.add(scroll, BorderLayout.NORTH);
        paddingPanel.add(new JLabel("Enter commands below:"), BorderLayout.CENTER);
        paddingPanel.add(cmdTextfield, BorderLayout.SOUTH);

        // add paddingPanel1 to the content pane and display it
        add(paddingPanel);
        pack();
        setVisible(true);
    }

    /**
     * Private class that responds to the command that
     * the user types in the command entry text field
     */
    private class CmdTextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmdText = cmdTextfield.getText();
            Scanner sc = new Scanner(cmdText);
            String cmd = sc.next();

            if(cmd.equals("addfront"))
            {
                String element = sc.nextLine();
                deque.addFront(element);
            }
            if(cmd.equals("addrear"))
            {
                String element = sc.nextLine();
                deque.addRear(element);
            }
            if(cmd.equals("removefront"))
            {
                deque.removeFront();
            }
            if(cmd.equals("removerear"))
            {
                deque.removeRear();
            }
            if(cmd.equals("exit"))
            {
                System.exit(0);
            }
            // Update the text area
            StringDequeView.setText(deque.toString());
            // Clear the command input field
            cmdTextfield.setText("");
            return;
        }
    }

}
