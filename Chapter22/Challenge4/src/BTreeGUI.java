/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/03/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BTreeGUI extends JFrame
{
    private BinaryTree binTree = new BinaryTree();
    private JTextField cmdResultTextField;
    private JTextField cmdTextField;


    /**
     * Constructor
     */
    public BTreeGUI()
    {
        setTitle("Challenge 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        // cmd text and cmd result label in north
        JPanel resultPanel = new JPanel(new GridLayout(1, 2));
        JLabel cmdResultLabel = new JLabel("Expression Result: ");
        cmdResultTextField = new JTextField();
        resultPanel.add(cmdResultLabel);
        resultPanel.add(cmdResultTextField);
        cmdResultTextField.setEditable(false);

        paddingPanel.add(resultPanel, BorderLayout.NORTH);

        // cmd label and cmd text field in south
        JLabel cmdLabel = new JLabel("Enter prefix expression: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        ActionListener cmdLis = new CmdTextListener();
        cmdTextField.addActionListener(cmdLis);

        paddingPanel.add(cmdPanel, BorderLayout.SOUTH);

        add(paddingPanel);

        // set up the frame
        pack();

        setVisible(true);
    }

    JPanel view = null;


    /**
     * The private inner class CmdTextListener reads in a prefix expression
     * adds it to a binary tree, calculates and displays the result.
     */
    private class CmdTextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmdStr = cmdTextField.getText();
            if(cmdStr.length()==0)
                return;

            binTree.clear();
            Scanner sc = new Scanner(cmdStr);

            char operation;
            int number;

            // Create a binary tree from the prefix expression
            while(sc.hasNext())
            {
                if (sc.hasNextInt()) {
                    number = sc.nextInt();
                    binTree.add(false, '\0', number);  // @ is a default value
                }
                else
                {
                    operation = sc.next().charAt(0);
                    if(operation!='+' && operation!='*')
                    {
                        cmdResultTextField.setText("Invalid operation '" + operation + "'");
                        pack();
                        return;
                    }
                    else
                        binTree.add(true, operation, 0);

                }
            }

            // Perform the calculation and display the result
            int result = binTree.calculate();
            cmdResultTextField.setText(cmdStr + " = " + result);
            cmdTextField.setText("");
            pack();
        }
    }
}