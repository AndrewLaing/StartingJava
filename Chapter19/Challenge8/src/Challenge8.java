/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/02/2017.
 */

import java.util.*;

public class Challenge8
{
    public static void main(String[] args)
    {
        // create a StringListTypeDemo
        OrderedStringSetType myList = new OrderedStringSetType();

        Scanner keyboard = new Scanner(System.in);

        // get a line of input
        System.out.println("Enter a series of words separated by spaces:");
        String input = keyboard.nextLine();

        // tokenise the string
        String[] tokens = input.split(" ");

        // add each of the tokens to the list
        for(String token : tokens)
            myList.add(token);

        // display the list
        System.out.println("Here is the iterator working:");

        Iterator it = myList.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
