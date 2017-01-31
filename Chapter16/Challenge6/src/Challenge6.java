import java.io.IOException;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/01/2017.
 */

import java.util.Scanner;

public class Challenge6
{
    public static void main(String[] args) throws IOException
    {
        String[] names = FileParser.parseFileToStringArray("names.txt");
        int arrayLength = names.length;
        String searchValue, input;
        int result;

        Scanner keyboard = new Scanner(System.in);

        // First sort the array into ascending order
        ObjectQuickSorter.quickSort(names);

        do {
            // Get a value to search for
            System.out.print("Enter a name to search for: ");
            searchValue = keyboard.nextLine();
            searchValue = searchValue.toUpperCase();

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
