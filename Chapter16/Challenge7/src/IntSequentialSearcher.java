/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/01/2017.
 */
public class IntSequentialSearcher
{
    // Benchmarking variables and methods
    private static int comparisonsMade;

    public static void setComparisonsMade(int comparisonsMade) {
        IntSequentialSearcher.comparisonsMade = comparisonsMade;
    }

    public static int getComparisonsMade() {
        return comparisonsMade;
    }

    // Search methods
    public static int search(int[] array, int value)
    {
        int index;
        int position;
        boolean found;

        index = 0;      // the starting point of the search
        position = -1;  // sentinel value returned if the value is not found
        found = false;  // flag

        while(!found && index < array.length)
        {
            comparisonsMade++;  // added for benchmarking

            if(array[index]==value)
            {
                found = true;
                position = index;
            }
            index++;
        }

        return position;
    }
}
