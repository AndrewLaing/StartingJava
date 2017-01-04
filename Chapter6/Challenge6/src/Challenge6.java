/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge6
{
    public static void main(String[] args)
    {
        DecimalFormat score = new DecimalFormat("#0.00");
        String input;       // to hold the user's input
        int temp;           // too temporarily hold the user's input as an int

        // Create a TestScores object
        TestScores candidate1 = new TestScores();

        // input the candidate's scores
        input = JOptionPane.showInputDialog("Please enter the first test score");
        temp = Integer.parseInt(input);
        candidate1.setTestScore1(temp);

        input = JOptionPane.showInputDialog("Please enter the second test score");
        temp = Integer.parseInt(input);
        candidate1.setTestScore2(temp);

        input = JOptionPane.showInputDialog("Please enter the third test score");
        temp = Integer.parseInt(input);
        candidate1.setTestScore3(temp);

        // Display the average score
        JOptionPane.showMessageDialog(null,"The average score for the candidate was " + score.format(candidate1.calculateAverage()));

        // Close the thread opened by the message dialogue
        System.exit(0);
    }
}
