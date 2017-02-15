/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/02/2017.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator class for the ListType class
 */
public class OrderedStringSetIterator implements Iterator<String>
{
    private OrderedStringSetType list;    // the list to iterate over
    private int previous;           // the previous element
    boolean canRemove;              // flag to manage removals


    /**
     * Constructor
     * @param aList The list to iterate over
     */
    public OrderedStringSetIterator(OrderedStringSetType aList)
    {
        // save the list reference
        list = aList;

        // by setting previous to -1 we are positioning
        // the iterator just before the first element
        previous = -1;

        // The remove method can only be called after the
        // next method has been called
        canRemove = false;
    }


    /**
     * The hasNext method determines whether another element
     * can be returned by a call to next
     * @return true if the iterator has more elements
     */
    public boolean hasNext()
    {
        if((previous + 1) < list.size())
            return true;
        else
            return false;
    }


    /**
     * The next method returns the next element in the list
     * @return the next element in the list
     */
    public String next()
    {
        if(!hasNext())
            throw new NoSuchElementException();

        // adding one to previous gives us the index
        // of the next element in the list
        previous++;

        // set canRemove to true to indicate that the
        // remove method can be called
        canRemove = true;

        // return the list element
        return list.get(previous);
    }


    /**
     * The remove method removes from the list the last
     * element that was returned by the next method
     */
    public void remove()
    {
        if(!canRemove)
            throw new IllegalStateException();

        // remove the previous element
        list.remove(previous);

        // adjust previous
        previous--;

        // reset the canRemove field. You can only remove once per call to next
        canRemove = false;
    }
}
