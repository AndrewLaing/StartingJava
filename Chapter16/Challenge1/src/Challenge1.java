/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/01/2017.
 */
public class Challenge1
{
    public static void main(String[] args) {
        String[] values = {"David", "Abe", "Katherine",
                "Beth", "Jeff", "Daisy" };

        // display the arrays contents
        System.out.println("Original order: ");
        for(String element : values)
            System.out.print(element + " ");

        // sort the array
        ObjectInsertionSorter.insertionSort(values);

        // display the arrays contents
        System.out.println("\nSorted order: ");
        for(String element : values)
            System.out.print(element + " ");

        System.out.println();
    }
}
