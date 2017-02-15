import java.util.Iterator;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/02/2017.
 */
public class ListType<E> implements GenericList<E>,
                                    Iterable<E>
{
    // Constants for the default capacity and resizing factor
    private final int DEFAULT_CAPACITY = 10;
    private final int RESIZE_FACTOR = 2;

    // private fields
    private E[] list;           // the list
    private int elements;       // the number of elements stored


    /**
     * Default no-args Constructor
     */
    public ListType()
    {
        // this is necessary because we cannot instantiate an array of generic type
        list = (E[]) (new Object[DEFAULT_CAPACITY]);
        elements = 0;
    }

    /**
     * Copy constructor
     * @param obj2 Object to be copied
     */
    public ListType(ListType<E> obj2)
    {
        list = (E[]) (new Object[obj2.getCapacity()]);
        int obj2Elements = obj2.elements;
        for(int index=0; index<obj2Elements; index++)
        {
            add(obj2.get(index));
        }

    }

    /**
     * Constructor that allows user to set the initial list size
     * @param capacity
     * @exception IllegalArgumentException When capacity is less than 1
     */
    public ListType(int capacity)
    {
        if (capacity < 1)
            throw new IllegalArgumentException();

        list = (E[]) (new Object[capacity]);
        elements = 0;
    }


    /**
     * The method getCapacity returns the current capacity of the list
     * @return The current capacity of the list
     */
    public int getCapacity()
    {
        return list.length;
    }

    /**
     * The method ensureCapacity resizes the list to have the minimum
     * capacity passed
     * @param minCapacity the minimum capacity that the list should hold
     * @return true if the list could be resized else false
     */
    public boolean ensureCapacity(int minCapacity)
    {
        // return false as it was unable to perform the operation
        // because something went wrong in the calculation
        if(minCapacity < elements )
            return false;

        // return true because the list can handle min capacity and the specification
        // does not want the list to be shrunk
        if(minCapacity <= getCapacity())
            return true;

        // create a new list
        E[] tempList = (E[]) (new Object[minCapacity]);

        // copy the existing elements to the new list
        for(int index=0; index<elements; index++)
            tempList[index] = list[index];

        // replace the existing list with the new one
        list = tempList;

        return true;
    }


    /**
     * The method trimToSize trim's the lists current capacity so it is
     * equal to the list's current size
     */
    public void trimToSize()
    {
        // create a new list
        E[] tempList = (E[]) (new Object[elements]);

        // copy the existing elements to the new list
        for(int index=0; index<elements; index++)
            tempList[index] = list[index];

        // replace the existing list with the new one
        list = tempList;
    }


    /**
     * Returns an iterator for this list
     * @return an iterator
     */
    public Iterator<E> iterator()
    {
        // passing itself as the list to create an iterator for
        return new ListTypeIterator<E>(this);
    }


    private void resize()
    {
        // Calculate the new length which is the current length
        // multiplied by the resize factor
        int newLength = list.length * RESIZE_FACTOR;

        // create a new list
        E[] tempList = (E[]) (new Object[newLength]);

        // copy the existing elements to the new list
        for(int index=0; index<elements; index++)
            tempList[index] = list[index];

        // replace the existing list with the new one
        list = tempList;
    }

    @Override
    public void add(E element)
    {
        // if the list is full resize it
        if(elements==list.length)
            resize();

        // add str to the end of the list
        list[elements] = element;

        // adjust the number of elements
        elements++;
    }

    @Override
    public void add(int index, E element)
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
        list[index] = element;

        // adjust the number of elements
        elements++;
    }


    /**
     * The method append appends the contents of the list passed to it
     * to the end of the list
     * @param obj2
     */
    public void append(ListType<E> obj2)
    {
        for(E element : obj2)
        {
            add(element);
        }
    }



    @Override
    public void clear()
    {
        for(int index=0; index < elements; index++)
            list[index] = null;

        elements = 0;

    }

    @Override
    public boolean contains(E element)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < elements)
        {
            if(list[index].equals(element))
                found = true;
            index++;
        }

        // return the status of the search
        return found;
    }

    @Override
    public E get(int index)
    {
        if(index > elements || index < 0)
            throw new IndexOutOfBoundsException();
        return list[index];
    }

    @Override
    public int indexOf(E element)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < elements)
        {
            if(list[index].equals(element))
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


    /**
     * The method lastIndexOf gets the index of the last occurrence of
     * the specified element
     * @param element The element to search for
     * @return The index of the first occurrence of element if it exists
     *         -1 if the element is not in the list
     */
    public int lastIndexOf(E element)
    {
        int index = -1;

        for(int i=0; i<elements; i++)
        {
            if(list[i].equals(element))
                index = i;
        }

        // return the status of the search
        return index;
    }


    @Override
    public boolean remove(E element)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < elements)
        {
            if(list[index].equals(element))
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
    public E remove(int index)
    {
        if(index >= elements || index < 0)
            throw new IndexOutOfBoundsException();

        // save the string but remove it from the list
        E temp = list[index];
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


    /**
     * This version of the remove method remove any items that appear in obj and list
     * from list
     * @param obj2
     */
    public void remove(ListType<E> obj2)
    {
        for(E element : obj2)
        {
            remove(element);
        }
    }


    public void removeRange(int fromIndex, int toIndex)
    {
        if(fromIndex >= elements || fromIndex < 0 || toIndex >= elements ||
                                      toIndex < 0 || fromIndex > toIndex )
            throw new IndexOutOfBoundsException();

        int index = 0;
        int newIndex = 0;

        while(index < elements)
        {
            if(index < fromIndex || index > toIndex)
            {
                list[newIndex] = list[index];
                newIndex++;
            }
            index++;
        }

        // remove the moved elements from the list
        while(newIndex < elements) {
            list[newIndex] = null;
            newIndex++;
        }

        // adjust the number of elements
        elements-=(toIndex-fromIndex+1);
    }




    @Override
    public E set(int index, E element) {
        if(index >= elements || index < 0)
            throw new IndexOutOfBoundsException();

        // save the string but remove it from the list
        E temp = list[index];

        // replace the string with str
        list[index] = element;

        // return the previously stored string
        return temp;
    }

    @Override
    public int size() {
        return elements;
    }

    /**
     * The method toStringArray converts the list to a string array
     * @return a string array representing the list
     */
    public String[] toStringArray()
    {
        // create a string array large enough to hold all of the elements in the list
        String[] strArray = new String[elements];

        // store each elements toString() return value as an element in the array
        for(int index=0; index<elements; index++)
            strArray[index]=list[index].toString();

        // return the string array
        return strArray;
    }

}
