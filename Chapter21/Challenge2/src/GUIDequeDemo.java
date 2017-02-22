/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/02/2017.
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUIDequeDemo extends JFrame
{
    private JTextField[] qViewTextField;
    private ArrayDeque deque;

    private JTextField commandEntryTextField;


    GUIDequeDemo(int capacity)
    {
        setTitle("Array Based Deque Demo");
        //setSize(400, 50);

        // create deque
        deque = new ArrayDeque(capacity);
        int qSize = deque.capacity();

        // Create view for deque and put it at the top of frame
        qViewTextField = new JTextField[qSize];
        LayoutManager layout = new GridLayout(1, qSize);
        JPanel qViewPanel = new JPanel(layout);
        for(int k=0; k<qViewTextField.length; k++)
        {
            qViewTextField[k] = new JTextField(10);
            JTextField t = qViewTextField[k];
            qViewPanel.add(t);
            t.setEditable(false);
            t.setBackground(Color.WHITE);
        }
        add(qViewPanel, BorderLayout.NORTH);

        // create commandEntryTextField and put it in
        // a panel at the bottom of the frame
        commandEntryTextField = new JTextField(15);
        ActionListener lis = new CmdTextListener();
        commandEntryTextField.addActionListener(lis);
        JPanel commandEntryPanel = new JPanel();
        commandEntryPanel.add(new JLabel("Command: "));
        commandEntryPanel.add(commandEntryTextField);
        add(commandEntryPanel, BorderLayout.SOUTH);

        // finish setting up the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    /**
     * This private inner class responds to the commands
     * typed into the command entry text field
     */
    private class CmdTextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            String cmdText = commandEntryTextField.getText();
            Scanner sc = new Scanner(cmdText);
            if(!sc.hasNext()) return;
            String cmd = sc.next();

            if(cmd.equals("addfront"))
            {
                String item = sc.next();
                System.out.println("Adding " + item);
                deque.addFront(item);
                refresh(deque.toString());
                return;
            }
            if(cmd.equals("addrear"))
            {
                String item = sc.next();
                System.out.println("Adding " + item);
                deque.addRear(item);
                refresh(deque.toString());
                return;
            }
            if(cmd.equals("removefront"))
            {
                System.out.println("Removing - " + deque.removeFront());
                refresh(deque.toString());
                return;
            }
            if(cmd.equals("removerear"))
            {
                System.out.println("Removing - " + deque.removeRear());
                refresh(deque.toString());
                return;
            }
            if(cmd.equals("exit"))
            {
                System.exit(0);
            }
        }


        /**
         * The refresh method stores the current
         * queue entries in the corresponding text
         * fields of the queue view
         * @param qStr The string encoding the current
         *             contents of the queue
         */
        private void refresh(String qStr)
        {
            Scanner sc = new Scanner(qStr);
            sc.nextLine();      // skip first/rear info
            while(sc.hasNext())
            {
                int k = sc.nextInt();
                String qEntry = sc.next();
                qViewTextField[k].setText(qEntry);
            }
        }
    }
}
