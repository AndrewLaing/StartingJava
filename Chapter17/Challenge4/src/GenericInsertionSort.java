/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/01/2017.
 */

/**
 * The difference between this class and ObjectInsertionSort is that because it
 * only accepts objects which extend Comparable it is type safe and does not accept
 * objects of, for example, the Number class which do not implement the Comparable
 * interface and would cause a runtime error
 */
public class GenericInsertionSort
{
    public static <T extends Comparable> void insertionSort(T[] array)
    {
        T unsortedValue;  // the first unsorted value
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
