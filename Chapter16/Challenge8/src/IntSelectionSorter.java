/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   17/01/2017.
 */
public class IntSelectionSorter
{
    // Benchmarking variables and methods
    private static int swapsMade;

    public static void setSwapsMade(int swapsMade) {
        IntSelectionSorter.swapsMade = swapsMade;
    }

    public static int getSwapsMade() {
        return swapsMade;
    }



    public static void selectionSort(int[] array) {

        int startScan;  // starting position of the scan
        int index;
        int minIndex;   // index of the smallest value in the scan
        int minValue;   // the smallest value found in the scan

        for (startScan=0; startScan<(array.length-1); startScan++)
        {
            minIndex = startScan;
            minValue = array[startScan];

            for (index = startScan+1; index<array.length; index++)
            {
                if(array[index] < minValue) {
                    minValue = array[index];
                    minIndex = index;
                }
            }

            // swap the element with the smallest value

            if(minIndex!=startScan)
                swapsMade++;  // added for benchmarking

            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }
    }
}
