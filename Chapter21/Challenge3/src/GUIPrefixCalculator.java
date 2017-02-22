/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/02/2017.
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUIPrefixCalculator extends JFrame
{
    private PrefixCalculator pCalc;
    private JTextField resultTextField;
    private JTextField expressionEntryTextField;

    public GUIPrefixCalculator()
    {
        pCalc = new PrefixCalculator();

        setTitle("Prefix Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create paddingPanel to add padding around the other panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Create the result panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));

        resultTextField = new JTextField(30);
        resultTextField.setEditable(false);

        resultPanel.add(new JLabel("Result of the expression"));
        resultPanel.add(resultTextField);

        // Create the expression entry panel
        JPanel expressionEntryPanel = new JPanel();
        expressionEntryPanel.setLayout(new GridLayout(2, 1));

        expressionEntryTextField = new JTextField(30);
        expressionEntryTextField.addActionListener(new ExpressionTextFieldListener());

        expressionEntryPanel.add(new JLabel("Enter expression below: "));
        expressionEntryPanel.add(expressionEntryTextField);

        paddingPanel.add(resultPanel, BorderLayout.NORTH);
        paddingPanel.add(expressionEntryPanel, BorderLayout.SOUTH);

        add(paddingPanel);
        pack();
        setVisible(true);

    }


    private class ExpressionTextFieldListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result;
            String expression = expressionEntryTextField.getText();

            result = pCalc.parseExpression(expression);

            resultTextField.setText(expression + " = " + result);
            pack();
            expressionEntryTextField.setText("");
        }
    }
}
