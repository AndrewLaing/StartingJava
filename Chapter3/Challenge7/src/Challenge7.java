/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/08/2016.
 */


import javax.swing.JOptionPane;

public class Challenge7
{
    public static void main(String[] args) {
        String first, second, third;
        String result = "";

        // Get the user to input the first name
        first = JOptionPane.showInputDialog("Enter name 1");

        // Get the user to input the second name
        second = JOptionPane.showInputDialog("Enter name 2");

        // Get the user to input the third name
        third = JOptionPane.showInputDialog("Enter name 3");

        // Sort the String array into the result string
        if(first.compareToIgnoreCase(second) < 0)
        {
            if(first.compareToIgnoreCase(third) < 0) {
                result += first + "\n";

                if(second.compareToIgnoreCase(third) < 0) {
                    result += second + "\n" + third;
                }
                else {
                    result += third + "\n" + second;
                }
            }
            else {
                result += third + "\n" + first + "\n" + second;
            }
        }
        else
        {
            if(second.compareToIgnoreCase(third) < 0) {
                result += second + "\n";

                if(first.compareToIgnoreCase(third) < 0) {
                    result += first + "\n" + third;
                }
                else {
                    result += third + "\n" + first;
                }
            }
            else {
                result += third + "\n" + second + "\n" + first;
            }
        }


        // Show the result to the user
        JOptionPane.showMessageDialog(null,result);

        // Close the thread created by the Message Dialog
        System.exit(0);
    }
}
