/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   07/02/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LinkedList1Demo extends JFrame
{
    private LinkedList1 ll;
    private JTextArea   listView;
    private JTextField  cmdTextField;
    private JTextField  resultTextField;

    public LinkedList1Demo()
    {
        ll = new LinkedList1();
        listView = new JTextArea();
        cmdTextField = new JTextField();
        resultTextField = new JTextField();

        // create a panel and label for result field
        JPanel resultPanel = new JPanel(new GridLayout(1, 2));
        resultPanel.add(new JLabel("Command result"));
        resultPanel.add(resultTextField);
        resultTextField.setEditable(false);
        add(resultPanel, BorderLayout.NORTH);

        // put the text area in the center of the frame
        add(listView, BorderLayout.CENTER);
        listView.setEditable(false);
        listView.setBackground(Color.WHITE);

        // Create a panel and label for the command text field
        JPanel cmdPanel = new JPanel(new GridLayout(2,1));
        cmdPanel.add(new JLabel("Command"));
        cmdPanel.add(cmdTextField);
        add(cmdPanel, BorderLayout.SOUTH);
        cmdTextField.addActionListener(new CmdTextListener());

        // set up the frame
        setTitle("Linked List Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    /**
     * Private class that responds to the command that
     * the user typesa ion the command entry text field
     */
    private class CmdTextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmdText = cmdTextField.getText();
            Scanner sc = new Scanner(cmdText);
            String cmd = sc.next();
            if(cmd.equals("add"))
            {
                if(sc.hasNextInt())
                {
                    // add index element
                    int index = sc.nextInt();
                    String element = sc.next();
                    ll.add(index, element);
                }
                else
                {
                    // add element
                    String element = sc.next();
                    ll.add(element);

                }
                listView.setText(ll.toString());
                pack();
                return;
            }
            if(cmd.equals("remove"))
            {
                if(sc.hasNextInt())
                {
                    // remove index
                    int index = sc.nextInt();
                    String res = ll.remove(index);
                    resultTextField.setText(res);
                }
                else
                {
                    // remove element
                    String element = sc.next();
                    boolean res = ll.remove(element);
                    String resText = String.valueOf(res);
                    resultTextField.setText(resText);
                }
                listView.setText(ll.toString());
                pack();
                return;
            }

            if(cmd.equals("reverse"))
            {
                ll.reverse();

                listView.setText(ll.toString());
                pack();
                return;
            }
            if(cmd.equals("sort"))
            {
                ll.sort();

                listView.setText(ll.toString());
                pack();
                return;
            }

            if(cmd.equals("isempty"))
            {
                String resText = String.valueOf(ll.isEmpty());
                resultTextField.setText(resText);
                return;
            }
            if(cmd.equals("size"))
            {
                String resText = String.valueOf(ll.size());
                resultTextField.setText(resText);
                return;
            }
        }
    }
}
