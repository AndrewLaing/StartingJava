/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/11/2016.
 */

import javax.swing.JOptionPane;

public class Challenge1
{

    public static String reverseString(String s)
    {
        char[] array = s.toCharArray();
        char[] reversed = new char[array.length];

        for(int i=0, j=array.length-1; i<array.length; i++, j--)
        {
            reversed[j] = array[i];
        }

        s = new String(reversed);

        return s;
    }


    public static void main(String[] args)
    {
        String str = JOptionPane.showInputDialog("Enter a string to reverse");
        str = reverseString(str);

        JOptionPane.showMessageDialog(null, str);
        System.exit(0);
    }
}
