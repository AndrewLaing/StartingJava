/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   16/01/2017.
 */
public class IntBubbleSorter
{

    // Benchmarking variables and methods
    private static int swapsMade;

    public static void setSwapsMade(int swapsMade) {
        IntBubbleSorter.swapsMade = swapsMade;
    }

    public static int getSwapsMade() {
        return swapsMade;
    }


    // note arrays are passed by reference
    public static void bubbleSort(int[] array)
    {
        int maxElement;     // the index of the last element to compare
        int index;          // index of an element to compare
        int temp;           // used to swap element

        for(maxElement = array.length-1; maxElement>=0; maxElement--)
        {
            for(index = 0; index<= maxElement-1; index++)
            {
                // compare an element with its neighbour
                if(array[index] > array[index+1])
                {
                    swapsMade++;  // added for benchmarking

                    // swap the two elements
                    temp = array[index];
                    array[index] = array[index+1];
                    array[index+1] = temp;
                }
            }
        }
    }
}
