import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   The AVLFrame class builds the user interface and 
   suports user interaction.
*/

public class AVLTreeDemo extends JFrame
implements ActionListener
{
    private AVLTree avlTree = new AVLTree();   
    private JLabel cmdResultLabel;
    
    private JLabel cmdLabel;
    private JTextField cmdTextField;
   
    public AVLTreeDemo()
    {
        setTitle("Challenge 3");
        
        // cmd text and cmd Result label in North
        JPanel resultPanel = new JPanel(new GridLayout(1,1));
        cmdResultLabel = new JLabel("Resultant tree: ");

        resultPanel.add(cmdResultLabel);

        add(resultPanel, BorderLayout.NORTH);
        
        // Leave center for binary tree view
        
        // cmd label and cmd text field in South
        cmdLabel = new JLabel("Enter a number: ");
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

        if(sc.hasNextInt())
        {
            int n = sc.nextInt();

            // clear the existing tree
            avlTree.clear();

            // create random array of integers
            Random randy = new Random();
            int[] arr = new int[n];

            for(int k=0; k<n; k++)
                arr[k] = randy.nextInt(100);

            // create a heap of Integers from the array
            // and use it sort the array
            ArrayHeap heap = new ArrayHeap();
            for(int x : arr)
                heap.add(x);
            for(int k=0; k<arr.length; k++)
            {
                arr[k] = heap.removeMin();
            }

            // iterate through the array adding them to the tree
            for(int x : arr)
                avlTree.add(x);

            // display the resultant tree
            if (view != null)
                remove(view);
            view = avlTree.getView();
            add(view);
            pack();
            validate();
        }
        else
        {
            String cmd = sc.next();
            if(cmd.equals("exit"))
            {
                System.exit(0);
            }
        }
    }
}