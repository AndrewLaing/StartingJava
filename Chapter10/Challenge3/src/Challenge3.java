/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/12/2016.
 */

import javax.swing.JOptionPane;
import java.util.StringTokenizer;


public class Challenge3
{

    public static String capitalise(String s)
    {
        StringTokenizer st = new StringTokenizer(s, ".?!", true);

        String result = "",
               temp = "";

        while(st.hasMoreTokens())
        {
            temp = st.nextToken().trim();

            if(temp.length() > 1)
                result += Character.toUpperCase(temp.charAt(0)) +
                          temp.substring(1);
            else if (temp.length() == 1){
                if(Character.isLetter(temp.charAt(0)))
                    result += Character.toUpperCase(temp.charAt(0));
                else
                    result += temp + " ";
            }
        }

        return result;

    }


    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Enter a string");
        input = capitalise(input);

        JOptionPane.showMessageDialog(null, input);
        System.exit(0);
    }
}
