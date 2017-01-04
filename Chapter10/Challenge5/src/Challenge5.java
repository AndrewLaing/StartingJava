/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/12/2016.
 */

import javax.swing.JOptionPane;

public class Challenge5
{

    public static boolean isValidPassword(String password)
    {
        if(password.length() < 6)
            return false;

        int uppers = 0,
            lowers = 0,
            digits = 0;

        char[] array = password.toCharArray();

        for(char c : array)
        {
            if(Character.isUpperCase(c))
                uppers++;
            if(Character.isLowerCase(c))
                lowers++;
            if(Character.isDigit(c))
                digits++;
        }

        return (uppers>0) && (lowers>0) && (digits>0);

    }


    public static void main(String[] args)
    {
        String password = JOptionPane.showInputDialog("Please enter your password.");

        if(isValidPassword(password))
            JOptionPane.showMessageDialog(null, "You have entered a valid password.");
        else
            JOptionPane.showMessageDialog(null, "You have entered a INVALID password!!");

        System.exit(0);
    }
}
