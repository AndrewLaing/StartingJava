/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/11/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class InputPanel extends JPanel
{
    // =========================================================================
    // ======== GUI ELEMENTS ===================================================
    // =========================================================================

    // Inner Panels
    private JPanel radioButtonPanel;
    private JPanel buttonPanel;

    // Action Button
    private JButton submitButton;

    // Descriptive Labels
    private JLabel questionLabel;

    // Radiobuttons
    private ButtonGroup radioButtonGroup;
    private JRadioButton ARadioBtn;
    private JRadioButton BRadioBtn;
    private JRadioButton CRadioBtn;
    private JRadioButton DRadioBtn;

    // =========================================================================
    // ======== OTHER ATTRIBUTES ===============================================
    // =========================================================================
    private int currentQuestion = 0;
    private String[][] testLabels;
    private int numberOfTests;
    private int correctAnswers = 0;
    private int labelsPerTest;
    private String nameOfTest, results;

    // =========================================================================
    // ======== METHODS ========================================================
    // =========================================================================

    /**
     * Constructor
     */
    public InputPanel() throws IOException
    {
        readInFileContents();

        createRadioButtonPanel();
        createButtonPanel();

        setLayout(new BorderLayout());

        // add the panels to the InputAndResults Panel
        add(radioButtonPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    public String getNameOfTest() {
        return nameOfTest;
    }

    /**
     * Method to read in the test details from a file
     */
    private void readInFileContents() throws IOException
    {
        String line;    // to hold a line of input

        // Open the file
        FileReader freader = new FileReader("20Questions.txt");
        BufferedReader fileInput = new BufferedReader(freader);

        line = fileInput.readLine().trim();
        numberOfTests = Integer.parseInt(line);
        line = fileInput.readLine().trim();
        labelsPerTest = Integer.parseInt(line);

        nameOfTest = fileInput.readLine();
        results = fileInput.readLine();
        numberOfTests = results.length();

        testLabels = new String[numberOfTests][labelsPerTest];

        // Read in the test texts
        for(int i=0; i<numberOfTests; i++)
        {
            for(int j=0; j<labelsPerTest; j++)
                testLabels[i][j] = fileInput.readLine();
        }

        // Close the file
        fileInput.close();
    }

    /**
     * Method to create the radio button panel
     */
    private void createRadioButtonPanel()
    {
        // Create the panel
        radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(5, 1));
        radioButtonPanel.setBorder(BorderFactory.createTitledBorder("Question 1"));

        // Create the labels
        questionLabel = new JLabel("");
        questionLabel.setFont(new Font("Sans", Font.ITALIC, 12));

        // Create the radio buttons
        radioButtonGroup = new ButtonGroup();
        ARadioBtn = new JRadioButton("", true); // default selected button
        BRadioBtn = new JRadioButton("");
        CRadioBtn = new JRadioButton("");
        DRadioBtn = new JRadioButton("");

        // Group the radio buttons together
        radioButtonGroup.add(ARadioBtn);
        radioButtonGroup.add(BRadioBtn);
        radioButtonGroup.add(CRadioBtn);
        radioButtonGroup.add(DRadioBtn);

        radioButtonPanel.add(questionLabel);
        radioButtonPanel.add(ARadioBtn);
        radioButtonPanel.add(BRadioBtn);
        radioButtonPanel.add(CRadioBtn);
        radioButtonPanel.add(DRadioBtn);

        // Add the first questions labels
        questionLabel.setText(testLabels[currentQuestion][0]);

        ARadioBtn.setText(testLabels[currentQuestion][1]);
        BRadioBtn.setText(testLabels[currentQuestion][2]);
        CRadioBtn.setText(testLabels[currentQuestion][3]);
        DRadioBtn.setText(testLabels[currentQuestion][4]);
    }

    /**
     * Method to create the button panel
     */
    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,4));

        submitButton = new JButton("SUBMIT");
        submitButton.setSize(60,80);

        // Register the event handler
        submitButton.addActionListener(new SubmitButtonListener());

        buttonPanel.add(submitButton, BorderLayout.EAST);
    }

    /**
     * Private inner class used to calculate and display the businessman's
     * expense details
     */
    private class SubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            checkAnswer();
            currentQuestion++;
            updateLabels();
        }

        private void showCorrectAnswer()
        {
            String correctAnswer;

            switch (results.charAt(currentQuestion)) {
                case 'A':
                    correctAnswer = testLabels[currentQuestion][1];
                    break;
                case 'B':
                    correctAnswer = testLabels[currentQuestion][2];
                    break;
                case 'C':
                    correctAnswer = testLabels[currentQuestion][3];
                    break;
                default:
                    correctAnswer = testLabels[currentQuestion][4];
                    break;
            }

            JOptionPane.showMessageDialog(null, "WRONG - The correct answer was;\n" + correctAnswer);
        }


        /**
         * The method checkAnswer compares the selected radio button against the result
         * for the current question if correct it adds 1 to the correctAnswers variable
         * otherwise it calls showCorrectAnswer
         */
        private void checkAnswer()
        {
            // compare selected radio button against the result for the current question
            // if correct add 1 to total
            char choice;

            if(ARadioBtn.isSelected())
                choice = 'A';
            else if(BRadioBtn.isSelected())
                choice = 'B';
            else if(CRadioBtn.isSelected())
                choice = 'C';
            else
                choice = 'D';

            if (choice == results.charAt(currentQuestion)) {
                JOptionPane.showMessageDialog(null, "CORRECT");
                correctAnswers++;
            }
            else {
                showCorrectAnswer();
            }
        }

        private void updateLabels()
        {
            if(currentQuestion >= numberOfTests)
            {
                String resultStr = "";
                if(correctAnswers>=15)
                    resultStr += "Congratulations - You PASSED the test.\n";
                else
                    resultStr += "Sorry - You FAILED the test.\n";
                resultStr += "You scored " + correctAnswers + " out of " + numberOfTests;
                resultStr += ".\nYou got " + (numberOfTests-correctAnswers) + " answers wrong!";
                JOptionPane.showMessageDialog(null, resultStr);
                System.exit(0);
            }

            // Update the radio button panel label
            String borderLabel = "Question " + Integer.toString(currentQuestion+1);
            radioButtonPanel.setBorder(BorderFactory.createTitledBorder(borderLabel));

            // TODO: 13/11/2016  How can I wrap texts so I can fix the width of the GUI to a reasonable size
            // Add the first questions labels
            questionLabel.setText(testLabels[currentQuestion][0]);

            ARadioBtn.setText(testLabels[currentQuestion][1]);
            ARadioBtn.setSelected(true);
            BRadioBtn.setText(testLabels[currentQuestion][2]);
            CRadioBtn.setText(testLabels[currentQuestion][3]);
            DRadioBtn.setText(testLabels[currentQuestion][4]);
        }
    }
}

