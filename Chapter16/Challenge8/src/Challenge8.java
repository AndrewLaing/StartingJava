/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/01/2017.
 */
public class Challenge8
{
    public static void main(String[] args)
    {
        int numbers[] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                8080152, 4562555, 5552012, 5050522, 7825877, 1250255,
                1005231, 6545231, 3852085, 7576651, 7881200, 4581002,
                4525356, 5578842, 6645854, 9999999, 0000000, 2536459
        };

        int numbers1[] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                8080152, 4562555, 5552012, 5050522, 7825877, 1250255,
                1005231, 6545231, 3852085, 7576651, 7881200, 4581002,
                4525356, 5578842, 6645854, 9999999, 0000000, 2536459
        };

        int numbers2[] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                8080152, 4562555, 5552012, 5050522, 7825877, 1250255,
                1005231, 6545231, 3852085, 7576651, 7881200, 4581002,
                4525356, 5578842, 6645854, 9999999, 0000000, 2536459
        };

        int numbers3[] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                8080152, 4562555, 5552012, 5050522, 7825877, 1250255,
                1005231, 6545231, 3852085, 7576651, 7881200, 4581002,
                4525356, 5578842, 6645854, 9999999, 0000000, 2536459
        };

        // Initialise the benchmarking variable
        IntBubbleSorter.setSwapsMade(0);
        IntInsertionSorter.setSwapsMade(0);
        IntSelectionSorter.setSwapsMade(0);
        IntQuickSorter.setSwapsMade(0);

        // Sort the arrays
        IntBubbleSorter.bubbleSort(numbers);
        IntInsertionSorter.insertionSort(numbers1);
        IntSelectionSorter.selectionSort(numbers2);
        IntQuickSorter.quickSort(numbers3);

        // Display the benchmarks
        System.out.println("BubbleSort made " + IntBubbleSorter.getSwapsMade() +
                " swaps to sort the array.");
        System.out.println("InsertionSort made " + IntInsertionSorter.getSwapsMade() +
                " swaps to sort the array.");
        System.out.println("SelectionSort made " + IntSelectionSorter.getSwapsMade() +
                " swaps to sort the array.");
        System.out.println("QuickSort made " + IntQuickSorter.getSwapsMade() +
                " swaps to sort the array.");
    }
}
