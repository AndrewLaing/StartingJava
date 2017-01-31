/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/01/2017.
 */

import java.util.Scanner;

public class Challenge3
{
    public static void main(String[] args)
    {
        int result = -1;
        String searchValue;
        String input;

        // an array of names to search
        String names[] = {"John", "Fred", "Sally", "Lori", "Kimberly", "Sarah", "Jimmy",
                "Sean", "Seamus", "Gerald", "Cassandra", "Laurent", "Cassie", "Davis",
                "Michael", "Cecil", "Cyril", "Xavier", "Zoe", "Alison"};

        Scanner keyboard = new Scanner(System.in);

        // First sort the array into ascending order
        ObjectQuickSorter.quickSort(names);

        do {
            // Get a value to search for
            System.out.print("Enter a value to search for: ");
            searchValue = keyboard.nextLine();

            result = ObjectBinarySearcher.search(names, searchValue);

            // display the results
            if(result == -1){
                System.out.println(searchValue + " was not found.");
            } else {
                System.out.println(searchValue + " was found at element " + result);
            }

            // does the user want to search again?
            System.out.print("Do you want to search again? (Y or N): ");
            input = keyboard.nextLine();

        } while(input.charAt(0)=='Y' || input.charAt(0)=='y');
    }
}
