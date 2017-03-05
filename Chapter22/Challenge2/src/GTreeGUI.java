/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   28/02/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GTreeGUI extends JFrame
{
    private GenealogyTree binTree = new GenealogyTree();
    private JLabel cmdResultLabel;
    private JTextField cmdResultTextField;

    private JLabel cmdLabel;
    private JTextField cmdTextField;

    public GTreeGUI()
    {
        setTitle("Binary Search Tree Operations");

        // cmd text and cmd result label in north
        JPanel resultPanel = new JPanel(new GridLayout(1, 2));
        cmdResultLabel = new JLabel("Command Result: ");
        cmdResultTextField = new JTextField();
        resultPanel.add(cmdResultLabel);
        resultPanel.add(cmdResultTextField);
        cmdResultTextField.setEditable(false);

        add(resultPanel, BorderLayout.NORTH);

        // Leave center for binary tree view

        // cmd label and cmd text field in south
        cmdLabel = new JLabel("Command: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        ActionListener cmdLis = new CmdTextListener();
        cmdTextField.addActionListener(cmdLis);
        add(cmdPanel, BorderLayout.SOUTH);

        // set up the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel view = null;


    private class CmdTextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmdStr = cmdTextField.getText();
            Scanner sc = new Scanner(cmdStr);
            String cmd = sc.next();

            if(cmd.equals("root"))
            {
                if(sc.hasNext()) {
                    String name = sc.next();
                    boolean added = binTree.addRoot(name);
                    if (view != null)
                        remove(view);
                    view = binTree.getView();
                    add(view);
                    pack();
                    validate();
                    cmdResultTextField.setText("addRoot = " + added);
                }
                else
                {
                    cmdResultTextField.setText("<< Invalid command >>");
                }
            }

            if(cmd.equals("left"))
            {
                if(sc.hasNext()) {
                    String parent = sc.next();
                    if(sc.hasNext()) {
                        String child = sc.next();
                        boolean added = binTree.addChild(true, parent, child);
                        if (view != null)
                            remove(view);
                        view = binTree.getView();
                        add(view);
                        pack();
                        validate();
                        cmdResultTextField.setText("addChild = " + added);
                    }
                    else
                    {
                        cmdResultTextField.setText("<< Invalid command >>");
                    }
                }
                else
                {
                    cmdResultTextField.setText("<< Invalid command >>");
                }
            }

            if(cmd.equals("right"))
            {
                if(sc.hasNext())
                {
                    String parent = sc.next();
                    if(sc.hasNext())
                    {
                        String child = sc.next();
                        boolean added = binTree.addChild(false, parent, child);
                        if (view != null)
                            remove(view);
                        view = binTree.getView();
                        add(view);
                        pack();
                        validate();
                        cmdResultTextField.setText("addChild = " + added);
                    }
                    else
                    {
                        cmdResultTextField.setText("<< Invalid command >>");
                    }
                }
                else
                {
                    cmdResultTextField.setText("<< Invalid command >>");
                }
            }

            if(cmd.equals("descendants"))
            {
                if(sc.hasNext()) {
                    String name = sc.next();
                    String found = binTree.descendants(name);
                    if (view != null)
                        remove(view);
                    view = binTree.getView();
                    add(view);
                    pack();
                    validate();
                    cmdResultTextField.setText(found);
                }
                else
                {
                    cmdResultTextField.setText("<< Invalid command >>");
                }
            }

            if(cmd.equals("ancestors"))
            {
                if(sc.hasNext()) {
                    String name = sc.next();
                    String found = binTree.ancestors(name);
                    if (view != null)
                        remove(view);
                    view = binTree.getView();
                    add(view);
                    pack();
                    validate();
                    cmdResultTextField.setText(found);
                }
                else
                {
                    cmdResultTextField.setText("<< Invalid command >>");
                }
            }


            if(cmd.equals("exit"))
            {
                System.exit(0);
            }
        }
    }
}
