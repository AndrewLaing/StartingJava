/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/08/2016.
 */

import javax.swing.JOptionPane;  // For the dialogue boxes
import java.util.Arrays;         // For the sort method

public class Challenge7a {
    public static void main(String[] args) {
        int arrLen = 3;
        String nameArray[] = new String[arrLen];
        String result = "";

        // Get the user to input the first name
        nameArray[0] = JOptionPane.showInputDialog("Enter name 1");

        // Get the user to input the second name
        nameArray[1] = JOptionPane.showInputDialog("Enter name 2");

        // Get the user to input the third name
        nameArray[2] = JOptionPane.showInputDialog("Enter name 3");

        // Sort the array
        Arrays.sort(nameArray);

        // Create the result string
        for(int i=0; i<arrLen; i++) {
            result += nameArray[i] + "\n";
        }

        // Show the result to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the Message Dialogue
        System.exit(0);
    }
}
