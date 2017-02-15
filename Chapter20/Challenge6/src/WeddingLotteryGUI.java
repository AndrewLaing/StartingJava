/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/02/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WeddingLotteryGUI extends JFrame
{
    // Reference to a WeddingLottery instance
    private WeddingLottery winAPrincess;

    // GUI Panels
    private JPanel paddingPanel1;
    private JPanel paddingPanel2;
    private JPanel paddingPanel3;

    // PaddingPanel1 components
    private JTextField inputTextfield;
    private JButton chooseButton;

    // PaddingPanel2 components
    private JTextArea   eliminatedListView;
    private JTextArea   remainingListView;
    private JTextField  rotateTextfield;

    // PaddingPanel3 components
    private JLabel resultLabel;


    /**
     * Constructor
     */
    public WeddingLotteryGUI()
    {
        // Create a WeddingLottery object
        winAPrincess = new WeddingLottery();

        setTitle("Wedding Lottery II");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the applications two panels
        createPaddingPanel1();
        createPaddingPanel2();
        createPaddingPanel3();

        // add paddingPanel1 to the content pane and display it
        add(paddingPanel1);
        pack();
        setVisible(true);
    }


    /**
     * The method createPaddingPanel1 creates the panel that adds suitors
     * to the selection list.
     */
    private void createPaddingPanel1()
    {
        // Create paddingPanel1
        paddingPanel1 = new JPanel();

        paddingPanel1.setLayout(new BorderLayout());
        paddingPanel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Create the components for paddingPanel1
        JLabel inputLabel = new JLabel("           Enter thy command, your Highness.           ");
        inputTextfield = new JTextField(10);
        inputTextfield.addActionListener(new CmdTextListener());
        chooseButton = new JButton("Choose");

        chooseButton.addActionListener(new ChooseButtonListener());

        // Add the components to paddingPanel1
        paddingPanel1.add(inputLabel, BorderLayout.NORTH);
        paddingPanel1.add(inputTextfield, BorderLayout.CENTER);
        paddingPanel1.add(chooseButton, BorderLayout.SOUTH);
    }


    /**
     * The method createPaddingPanel3 creates the panel that selects
     * the winning suitor.
     */
    private void createPaddingPanel2()
    {
        // Create paddingPanel2
        paddingPanel2 = new JPanel();

        paddingPanel2.setLayout(new BorderLayout());
        paddingPanel2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Create the label panel that contains the labels for
        //        the text areas
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 2));

        JLabel elimLabel = new JLabel("Eliminated Suitors:       ");
        JLabel remLabel  = new JLabel("Remaining Suitors:       ");
        labelPanel.add(elimLabel);
        labelPanel.add(remLabel);

        // Create the text panel that contains the text areas
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 2));

        eliminatedListView = new JTextArea();
        remainingListView = new JTextArea();

        eliminatedListView.setRows(10);
        remainingListView.setRows(10);

        textPanel.add(eliminatedListView);
        textPanel.add(remainingListView);

        // Create the input panel that contains the rotate steps
        //        input field and its label
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        JLabel rotateLabel = new JLabel("Enter steps to rotate");
        rotateLabel.setHorizontalAlignment(SwingConstants.LEFT);

        rotateTextfield = new JTextField(10);
        rotateTextfield.addActionListener(new RotateTextListener());

        inputPanel.add(rotateLabel);
        inputPanel.add(rotateTextfield);

        // Add the three panels to paddingPanel2
        paddingPanel2.add(labelPanel, BorderLayout.NORTH);
        paddingPanel2.add(textPanel, BorderLayout.CENTER);
        paddingPanel2.add(inputPanel, BorderLayout.SOUTH);
    }


    /**
     * The method createPaddingPanel3 creates the panel that shows
     * the winning suitor.
     */
    private void createPaddingPanel3()
    {
        // Create paddingPanel1
        paddingPanel3 = new JPanel();

        paddingPanel3.setLayout(new BorderLayout());
        paddingPanel3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Create the components used in paddingPanel3
        resultLabel = new JLabel("");
        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(new ExitButtonListener());

        // Add the components to paddingPanel3
        paddingPanel3.add(resultLabel, BorderLayout.NORTH);
        paddingPanel3.add(exitButton, BorderLayout.SOUTH);
    }


    /**
     * Private class that responds to the command that
     * the user types in the command entry text field
     */
    private class CmdTextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cmdText = inputTextfield.getText();
            Scanner sc = new Scanner(cmdText);
            String cmd = sc.next();

            // The inputTextField only accepts the command 'add suitorname'
            if(cmd.equals("add"))
            {
                String suitor = sc.nextLine();
                winAPrincess.addToHopeful(suitor);
            }

            // Clear the text field
            inputTextfield.setText("");
            return;
        }
    }


    /**
     * Private class that responds to the choose button being pressed
     */
    private class ChooseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Close the add suitors panel and open the choose groom panel
            getContentPane().removeAll();
            getContentPane().add(paddingPanel2);

            // Update the TextAreas
            String eliminated = "";
            String hopeful = "";

            for(String s : winAPrincess.getEliminated() )
                eliminated += s + "\n";

            for(String s : winAPrincess.getHopeful() )
                hopeful += s + "\n";

            eliminatedListView.setText(eliminated);
            remainingListView.setText(hopeful);
            pack();
            setVisible(true);
        }
    }


    /**
     * Private class that responds to the enter button being pressed
     * inside of the rotateTextfield
     */
    private class RotateTextListener implements ActionListener
    {
        private void showResultPanel()
        {
            // Close the select groom panel and show the results panel
            getContentPane().removeAll();
            getContentPane().add(paddingPanel3);

            String result = "Ahem, you forgot to add suitors your Highness.";
            if(winAPrincess.getHopeful().size()>0)
            {
                result = "        The winning suitor is " + winAPrincess.getHopeful().get(0) + "        ";
            }

            resultLabel.setText(result);
            pack();
            setVisible(true);
        }


        public void actionPerformed(ActionEvent e)
        {
            if(winAPrincess.getHopeful().size() <= 1)
            {
                showResultPanel();
                return;
            }

            String rotateText = rotateTextfield.getText();
            Scanner sc = new Scanner(rotateText);

            int rotateSteps;

            // Only accept numerical input
            if(sc.hasNextInt())
            {
                rotateSteps = sc.nextInt();
                // remove a suitor
                winAPrincess.eliminateSuitor(rotateSteps);
            }

            if(winAPrincess.getHopeful().size() == 1)
            {
                showResultPanel();
            }
            else
            {
                // Clear the text field
                rotateTextfield.setText("");

                // Update the text areas
                String eliminated = "";
                String hopeful = "";

                for (String s : winAPrincess.getEliminated())
                    eliminated += s + "\n";

                for (String s : winAPrincess.getHopeful())
                    hopeful += s + "\n";

                eliminatedListView.setText(eliminated);
                remainingListView.setText(hopeful);
                pack();
                setVisible(true);
            }
        }
    }


    /**
     * Private class that responds to the exit button being pressed
     */
    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Quit the application
            System.exit(0);
        }
    }
}
