/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/08/2016.
 */

import javax.swing.JOptionPane;

public class Challenge6 {
    public static void main(String[] args) {
        String input;       // To hold the users input
        String result = "";      // To hold the result string
        int seconds, minutes, hours, days;

        // Get 6the user to input the number of seconds
        input = JOptionPane.showInputDialog("Enter the number of seconds");
        // Convert input to an integer
        seconds = Integer.valueOf(input);

        // Allow negative input
        if(seconds<0) {
            result += "Minus ";
            seconds = Math.abs(seconds);
        }

        // Convert the input to a result string
        if(seconds >= 86400) {
            days = seconds/86400;
            seconds = seconds%86400;
            result += Integer.toString(days) + " days ";
        }

        if(seconds >=3600) {
            hours = seconds / 3600;
            seconds = seconds % 3600;
            result += Integer.toString(hours) + " hours ";
        }

        if(seconds >=60) {
            minutes = seconds / 60;
            seconds = seconds % 60;
            result += Integer.toString(minutes) + " minutes ";
        }

        result += Integer.toString(seconds) + " seconds";

        // Show the result to the user
        JOptionPane.showMessageDialog(null,result);

        // Close the thread created by the messagebox
        System.exit(0);
    }
}
