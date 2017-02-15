/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/02/2017.
 */

import java.util.*;

public class Challenge6
{
    public static void main(String[] args)
    {
        // create a StringListTypeDemo
        OrderedStringListType myList = new OrderedStringListType();

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
        System.out.println("Here are the words you entered:");
        displayList(myList);
    }


    public static void displayList(StringList list)
    {
        for(int i=0; i<list.size(); i++)
            System.out.println("Index " + i + ": " + list.get(i));

        System.out.println();
    }

}
