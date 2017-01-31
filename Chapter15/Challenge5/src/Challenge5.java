/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   15/01/2017.
 */
public class Challenge5
{
    public static boolean isPalindrome(String str)
    {
        int i = str.length();
        if(i<=1)
            return true;

        boolean isPal;
        if(str.charAt(0)!=str.charAt(i-1))
            return false;
        isPal = isPalindrome(str.substring(1,i-1));
        return isPal;

    }

    public static void main(String[] args)
    {
        String one = "madamImadam";
        String two = "obviouslynotapalindrome";

        if(isPalindrome(one)) {
            System.out.println(one + " is a Palindrome.");
        }
        else {
            System.out.println(one + " is NOT a Palindrome.");
        }

        if(isPalindrome(two)) {
            System.out.println(two + " is a Palindrome.");
        }
        else {
            System.out.println(two + " is NOT a Palindrome.");
        }
    }
}
