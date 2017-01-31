/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/01/2017.
 */
public class ObjectInsertionSorter
{
    public static void insertionSort(Comparable[] array)
    {
        Comparable unsortedValue;  // the first unsorted value
        int scan;                  // used to scan the array

        for(int index=1; index<array.length; index++)
        {
            unsortedValue = array[index];

            scan = index;

            while(scan>0 && (array[scan-1].compareTo(unsortedValue)) > 0)
            {
                array[scan] = array[scan-1];
                scan--;
            }

            array[scan] = unsortedValue;
        }
    }
}
