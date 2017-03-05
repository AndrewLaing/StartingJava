import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   The AVLFrame class builds the user interface and 
   supports user interaction.
*/

public class AVLTreeDemo extends JFrame
implements ActionListener
{
    private AVLTree avlTree = new AVLTree();
    private JLabel cmdResultLabel;
    private JTextField cmdResultTextField;
    
    private JLabel cmdLabel;
    private JTextField cmdTextField;
   
    public AVLTreeDemo()
    {
        setTitle("Challenge 5");
        
        // cmd text and cmd Result label in North
        JPanel resultPanel = new JPanel(new GridLayout(1,2));
        cmdResultLabel = new JLabel("Command Result: ");
        cmdResultTextField = new JTextField();
        resultPanel.add(cmdResultLabel);
        resultPanel.add(cmdResultTextField);
        cmdResultTextField.setEditable(false);
        add(resultPanel, BorderLayout.NORTH);
        
        // Leave center for binary tree view
        
        // cmd label and cmd text field in South
        cmdLabel = new JLabel("Command: ");
        cmdTextField = new JTextField();
        JPanel cmdPanel = new JPanel(new GridLayout(1,2));
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);
        cmdTextField.addActionListener(this);
        add(cmdPanel, BorderLayout.SOUTH);

        // Set up the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    JPanel view = null;
    
    /**
       This method interprets user commands 
       entered in the command entry text field.
       @return evt The action event from the 
       command entry text field.
    */
    public void actionPerformed(ActionEvent evt)
    {
        String cmdStr = cmdTextField.getText();
        Scanner sc = new Scanner(cmdStr);
        String cmd = sc.next();
        if (cmd.equals("add"))
        {
            if(sc.hasNextInt()) {
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
        if (cmd.equals("level"))
        {
            if(sc.hasNextInt()) {
                int value = sc.nextInt();
                int res = avlTree.level(value);

                if(res==-1)
                    cmdResultTextField.setText(value + " not found in tree!");
                else
                    cmdResultTextField.setText(value + " is at level " + res);
                pack();
            }
        }
        if(cmd.equals("exit"))
            System.exit(0);
    } 
	 
    /**
	    The main method creates an instance of the 
       AVLTreeDemo class which causes it to display
       its window.
   */
	 
    public static void main(String [ ] args)
    {
      AVLTreeDemo atd =  new AVLTreeDemo();
    }    
}