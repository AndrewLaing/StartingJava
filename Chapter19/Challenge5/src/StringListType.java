/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/02/2017.
 */
public class StringListType implements StringList
{
    // Constants for the default capacity and resizing factor
    private final int DEFAULT_CAPACITY = 10;
    private final int RESIZE_FACTOR = 2;

    // private fields
    private String[] list;      // the list
    private int elements;       // tyhe number of elements stored


    /**
     * Default no-args Constructor
     */
    public StringListType()
    {
        list = new String[DEFAULT_CAPACITY];
        elements = 0;
    }


    /**
     * Constructor that allows user to set the initial list size
     * @param capacity
     * @exception IllegalArgumentException When capacity is less than 1
     */
    public StringListType(int capacity)
    {
        if (capacity < 1)
            throw new IllegalArgumentException();

        list = new String[capacity];
        elements = 0;
    }


    public void quickSort() {
        doQuickSort(list, 0, elements-1);
    }

    private void doQuickSort(Comparable[] array, int start, int end)
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


    private int partition(Comparable[] array, int start, int end)
    {
        Comparable pivotValue;
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
            if(array[scan].compareTo(pivotValue) < 0) {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }

        // move the pivot value to the end of the left sublist
        swap(array, start, endOfLeftList);

        // return the subscript of the pivot value
        return endOfLeftList;

    }

    private void swap(Comparable[] array, int a, int b)
    {
        Comparable temp;

        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    private void resize()
    {
        // Calculate the new length which is the current length
        // multiplied by the resize factor
        int newLength = list.length * RESIZE_FACTOR;

        // create a new list
        String[] tempList = new String[newLength];

        // copy the existing elements to the new list
        for(int index=0; index<elements; index++)
            tempList[index] = list[index];

        // replace the existing list with the new one
        list = tempList;
    }

    @Override
    public void add(String str)
    {
        // if the list is full resize it
        if(elements==list.length)
            resize();

        // add str to the end of the list
        list[elements] = str;

        // adjust the number of elements
        elements++;
    }

    @Override
    public void add(int index, String str)
    {
        // if the list is full resize it
        if(index > elements || index < 0)
            throw new IndexOutOfBoundsException();

        // if the list is full resize it
        if(elements==list.length)
            resize();

        // shift the elements starting at index to the right one position
        for(int index2 = elements; index2 > index; index2--)
            list[index2] = list[index2 - 1];

        // add the new element at index
        list[index] = str;

        // adjust the number of elements
        elements++;
    }

    @Override
    public void clear()
    {
        for(int index=0; index < elements; index++)
            list[index] = null;

        elements = 0;

    }

    @Override
    public boolean contains(String str)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < elements)
        {
            if(list[index].equals(str))
                found = true;
            index++;
        }

        // return the status of the search
        return found;
    }

    @Override
    public String get(int index)
    {
        if(index > elements || index < 0)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    @Override
    public int indexOf(String str)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < elements)
        {
            if(list[index].equals(str))
                found = true;
            else
                index++;
        }

        if(!found)
            index = -1;

        // return the status of the search
        return index;
    }

    @Override
    public boolean isEmpty() {
        return (elements == 0);
    }

    @Override
    public boolean remove(String str)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < elements)
        {
            if(list[index].equals(str))
                found = true;
            index++;
        }

        // if the value was found shift all subsequent values toward
        // the front of the list
        if(found)
        {
            while(index < elements)
            {
                list[index - 1] = list[index];
                index++;
            }

            // adjust the number of elements
            elements--;
        }

        // return the status of the search
        return found;
    }

    @Override
    public String remove(int index)
    {
        if(index >= elements || index < 0)
            throw new IndexOutOfBoundsException();

        // save the string but remove it from the list
        String temp = list[index];
        list[index] = null;
        index++;

        while(index < elements)
        {
            list[index - 1] = list[index];
            index++;
        }

        // adjust the number of elements
        elements--;

        // return the string that was removed
        return temp;
    }

    @Override
    public String set(int index, String str) {
        if(index >= elements || index < 0)
            throw new IndexOutOfBoundsException();

        // save the string but remove it from the list
        String temp = list[index];

        // replace the string with str
        list[index] = str;

        // return the previously storedstring
        return temp;
    }

    @Override
    public int size() {
        return elements;
    }

    public String[] toStringArray()
    {
        // Create a String array large enough to hold all
        // of the elements in the array
        String[] stringArray = new String[elements];

        // Store the elements in the array
        for(int index=0; index < elements; index++)
            stringArray[index] = list[elements];

        // return the string array
        return stringArray;
    }
}
