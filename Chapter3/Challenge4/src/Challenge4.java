/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/08/2016.
 */

import javax.swing.JOptionPane;

public class Challenge4
{
    public static void main(String[] args) {
        String input;                               // To hold the user's input before converting it
        double result1, result2, result3, average;  // To hold the scores and their average
        char grade;

        // Get the user to input the first score
        input = JOptionPane.showInputDialog("Input the first result");
        // Convert the input to a double to store in result1
        result1 = Double.valueOf(input);

        // Get the user to input the second score
        input = JOptionPane.showInputDialog("Input the second result");
        // Convert the input to a double to store in result2
        result2 = Double.valueOf(input);

        // Get the user to input the last score
        input = JOptionPane.showInputDialog("Input the final result");
        // Convert the input to a double to store in result3
        result3 = Double.valueOf(input);

        // Calculate the average
        average = (result1+result2+result3)/3;

        // Calculate the grade
        if(average>=90)
            grade='A';
        else if(average>=80)
            grade='B';
        else if(average >=70)
            grade='C';
        else if(average>=60)
            grade='D';
        else
            grade='F';

        // Show the user the result
        JOptionPane.showMessageDialog(null,"Your final grade was " + grade);

        // Close the thread created by the MessageBox
        System.exit(0);
    }
}
