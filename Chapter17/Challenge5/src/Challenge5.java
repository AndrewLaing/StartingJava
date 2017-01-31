/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/01/2017.
 */

import java.util.Scanner;

public class Challenge5
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
        GenericInsertionSort.insertionSort(names);

        do {
            // Get a value to search for
            System.out.print("Enter a name to search for: ");
            searchValue = keyboard.nextLine();

            result = GenericBinarySearcher.search(names, searchValue);

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


        result = -1;
        Integer searchNum;

        Integer[] numbers = {21,54,32,65,21,54,65,87,654,45,86,78,897};


        // First sort the array into ascending order
        GenericInsertionSort.insertionSort(numbers);

        do {
            // Get a value to search for
            System.out.print("Enter a number to search for: ");
            input = keyboard.nextLine();
            searchNum = Integer.parseInt(input);

            result = GenericBinarySearcher.search(numbers, searchNum);

            // display the results
            if(result == -1){
                System.out.println(searchNum + " was not found.");
            } else {
                System.out.println(searchNum + " was found at element " + result);
            }

            // does the user want to search again?
            System.out.print("Do you want to search again? (Y or N): ");
            input = keyboard.nextLine();

        } while(input.charAt(0)=='Y' || input.charAt(0)=='y');
    }


}
