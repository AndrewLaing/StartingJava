/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/01/2017.
 */

import java.util.*;

public class Challenge1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String input;
        System.out.println("Enter a line of text: ");

        // get some input from the user
        input = keyboard.nextLine();


        // first replace all other word delimiters that appear in
        // the string with spaces and then split it into words
        input = input.replaceAll("[!?,]", " "); // first replace all other word delimiters
        String[] tokens = input.trim().split(" ");

        // Create a TreeSet because it stores in a sorted order
        Set<String> tokenSet = new TreeSet<String>();

        // Add the tokens to the set ignoring any empty strings
        for(String token : tokens)
        {
            if(token.length() > 0)
                tokenSet.add(token);
        }

        // display the tokens
        for(String token : tokenSet)
            System.out.println(token);

    }
}
