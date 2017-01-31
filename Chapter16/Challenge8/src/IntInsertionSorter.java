/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   17/01/2017.
 */
public class IntInsertionSorter
{
    // Benchmarking variables and methods
    private static int swapsMade;

    public static void setSwapsMade(int swapsMade) {
        IntInsertionSorter.swapsMade = swapsMade;
    }

    public static int getSwapsMade() {
        return swapsMade;
    }


    public static void insertionSort(int[] array)
    {
        int unsortedValue;  // the first unsorted value
        int scan;           // used to scan the array

        for(int index=1; index<array.length; index++)
        {
            unsortedValue = array[index];

            scan = index;
            // shuffle up the elements of the array to make room for
            // unsortedValue in its correct position by moving values
            // larger than unsortedValue towards the end of the array
            while(scan>0 && array[scan-1] > unsortedValue)
            {
                swapsMade++;  // added for benchmarking

                array[scan] = array[scan-1];
                scan--;
            }

            if(array[scan]!=unsortedValue)
                swapsMade++;  // added for benchmarking

            array[scan] = unsortedValue;
        }
    }
}
