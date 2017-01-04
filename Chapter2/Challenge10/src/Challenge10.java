/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/08/2016.
 */

import javax.swing.JOptionPane;

public class Challenge10 {
    public static void main(String[] args) {
        String inputString;         // For reading input
        int test1, test2, test3;    // testScores
        double average;             // average test score

        JOptionPane.showMessageDialog(null, "Please input the three test results");

        // Get the result of the first test
        inputString = JOptionPane.showInputDialog("What was the first result? ");

        // Convert the input to an int
        test1 = Integer.parseInt(inputString);

        // Get the result of the second test
        inputString = JOptionPane.showInputDialog("What was the second result? ");

        // Convert the input to an int
        test2 = Integer.parseInt(inputString);

        // Get the result of the third test
        inputString = JOptionPane.showInputDialog("What was the last result? ");

        // Convert the input to an int
        test3 = Integer.parseInt(inputString);

        average = (test1 + test2 + test3)/ 3.0;

        String result = String.format("The average result was %.2f", average);

        JOptionPane.showMessageDialog(null, result);

        System.exit(0);
    }
}
