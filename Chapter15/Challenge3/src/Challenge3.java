/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   15/01/2017.
 */
public class Challenge3
{
    public static void reverser(String str)
    {
        int i = str.length();

        // Send substrings of str until the last character is reached
        if(i>1)
            reverser(str.substring(1));

        // print out the first character of the string
        System.out.print(str.charAt(0));
    }

    public static void main(String[] args) {
        String str = "reverseme";

        reverser(str);
    }
}
