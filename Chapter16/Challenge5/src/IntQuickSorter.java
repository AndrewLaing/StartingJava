/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/01/2017.
 */
public class IntQuickSorter
{
    public static void quickSort(int[] array) {
        doQuickSort(array, 0, array.length-1);
    }

    private static void doQuickSort(int[] array, int start, int end)
    {
        int pivotPoint;

        if(start < end)
        {
            // get the pivot point
            pivotPoint = partition(array, start, end);

            // sort the first sublist
            doQuickSort(array, start, pivotPoint-1);

            // sort the second sublist
            doQuickSort(array, pivotPoint+1, end);
        }
    }


    private static int partition(int[] array, int start, int end)
    {
        int pivotValue;
        int endOfLeftList;
        int mid;

        // find the subscript of the middle element
        mid = (start + end) /2;

        // swap the middle element with the first element
        // this moves the pivot value to the start of the list
        swap(array, start, mid);

        // save the pivot value for comparisons
        pivotValue = array[start];

        // for now the end of the left sublist is the first element
        endOfLeftList = start;

        // scan the entire list and move any values that are less than the pivot value
        // to the left sublist
        for(int scan = start + 1; scan<= end; scan++)
        {
            if(array[scan] < pivotValue) {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }

        // move the pivot value to the end of the left sublist
        swap(array, start, endOfLeftList);

        // return the subscript of the pivot value
        return endOfLeftList;

    }

    public static void swap(int[] array, int a, int b)
    {
        int temp;

        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
