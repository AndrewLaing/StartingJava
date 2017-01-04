/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/12/2016.
 */

import javax.swing.JOptionPane;

public class Challenge2
{
    public static int wordCounter(String toSplit)
    {
        int counter = 0;
        String[] tokens = toSplit.trim().split(" ");
        for(String token : tokens)
            counter++;

        return counter;
    }

    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Input a string");
        int wc = wordCounter(input);

        JOptionPane.showMessageDialog(null, "The string you entered has " + wc + " characters.");
        System.exit(0);
    }
}
