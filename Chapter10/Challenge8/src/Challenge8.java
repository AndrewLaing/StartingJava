/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/12/2016.
 */

import javax.swing.JOptionPane;

public class Challenge8
{
    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Enter a string of numbers seperated by commas");

        String array[] = input.split(",");

        int total = 0;

        try {
            for (int i = 0; i < array.length; i++)
                total += Integer.parseInt(array[i]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sorry, you have entered an incorrect string!");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "The sum of the numbers is " + total);
        System.exit(0);

    }
}
