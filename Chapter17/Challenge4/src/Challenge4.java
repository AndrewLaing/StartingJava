/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/01/2017.
 */
public class Challenge4
{
    public static void main(String[] args)
    {
        String[] values = {"David", "Abe", "Katherine",
                "Beth", "Jeff", "Daisy" };

        // display the arrays contents
        System.out.println("Original order: ");
        for(String element : values)
            System.out.print(element + " ");

        // sort the array
        GenericInsertionSort.insertionSort(values);

        // display the arrays contents
        System.out.println("\nSorted order: ");
        for(String element : values)
            System.out.print(element + " ");

        System.out.println();


        Integer[] nums = {12, 13, 15, 55, 33, 4, 55, 9, 6};

        // display the arrays contents
        System.out.println("Original order: ");
        for(Integer element : nums)
            System.out.print(element + " ");

        // sort the array
        GenericInsertionSort.insertionSort(nums);

        // display the arrays contents
        System.out.println("\nSorted order: ");
        for(Integer element : nums)
            System.out.print(element + " ");

        System.out.println();

    }
}
