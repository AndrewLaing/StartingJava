/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/02/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AVLTreesDemo extends JFrame
                          implements ActionListener
{
    private AVLTrees avlTree = new AVLTrees();
    private JLabel cmdResultLabel;
    private JTextField cmdResultTextField;

    private JLabel cmdLabel;
    private JTextField cmdTextField;

    public AVLTreesDemo()
    {
        setTitle("Challenge 1 - AVL Tree");

        // cmd text and cmd result label in north
        JPanel resultPanel = new JPanel(new GridLayout(1,2));
        cmdResultLabel = new JLabel("Command Result: ");
        cmdResultTextField = new JTextField();
        cmdResultTextField.setEditable(false);
        resultPanel.add(cmdResultLabel);
        resultPanel.add(cmdResultTextField);
        add(resultPanel, BorderLayout.NORTH);

        // Leave center for binary tree view

        // cmd label and cmd text field in south
        cmdLabel = new JLabel("Command: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        cmdTextField.addActionListener(this);
        add(cmdPanel, BorderLayout.SOUTH);

        // set up the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel view = null;


    /**
     * This method interprets user commands
     * entered into the command entry text field
     * @param e The action event from the
     *          command entry text field
     */
    public void actionPerformed(ActionEvent e)
    {
        String cmdStr = cmdTextField.getText();
        Scanner sc = new Scanner(cmdStr);
        String cmd = sc.next();
        if(cmd.equals("add"))
        {
            if(sc.hasNextInt())
            {
                int value = sc.nextInt();
                avlTree.add(value);
                if (view != null)
                    remove(view);
                view = avlTree.getView();
                add(view);
                pack();
                validate();
                cmdResultTextField.setText(" ");
            }
        }
        if(cmd.equals("contains"))
        {
            if(sc.hasNextInt())
            {
                int value = sc.nextInt();

                cmdResultTextField.setText("Contains " + value + "? = " + avlTree.contains(value));
            }
        }
        if(cmd.equals("exit"))
        {
            System.exit(0);
        }
        if(cmd.equals("remove"))
        {
            if(sc.hasNextInt())
            {
                int value = sc.nextInt();
                avlTree.remove(value);
                if (view != null)
                    remove(view);
                view = avlTree.getView();
                add(view);
                pack();
                validate();
                cmdResultTextField.setText(" ");
            }
        }
    }

}
