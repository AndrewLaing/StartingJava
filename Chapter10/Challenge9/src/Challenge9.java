/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/12/2016.
 */
import javax.swing.JOptionPane;

public class Challenge9
{
    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Enter a string of numbers separated by commas");

        char array[] = input.toCharArray();

        int total = 0;
        String temp;

        try {
            for (int i = 0; i < array.length; i++) {
                temp = "" + array[i];
                total += Integer.parseInt(temp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sorry, you have entered an incorrect string!");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "The sum of the numbers is " + total);
        System.exit(0);

    }
}
