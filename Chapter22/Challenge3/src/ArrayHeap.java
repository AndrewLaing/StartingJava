/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   28/02/2017.
 */

import java.util.*;

public class ArrayHeap
{
    private ArrayList<Integer> arrayHeap =
            new ArrayList<Integer>();


    /**
     * The siftUp method sifts up the element
     * at arrayHeap[size()-1]
     */
    private void siftUp()
    {
        int p = arrayHeap.size()-1;     // position to sift up
        while(p != 0)
        {
            int parent = (p-1) / 2;
            if(valueAt(p) >= valueAt(parent))
            {
                // we are done
                break;
            }
            else
            {
                // Do a swap
                Integer temp = arrayHeap.get(parent);
                arrayHeap.set(parent, arrayHeap.get(p));
                arrayHeap.set(p, temp);

                // move up
                p = parent;
            }
        }
    }


    /**
     * The siftDown method sifts down the element
     * at arrayHeap[0]
     */
    private void siftDown()
    {
        int p = 0;  // position to sift down
        int size = arrayHeap.size();
        while(2*p + 1 < size)
        {
            int leftChildPos = 2*p + 1;
            int rightChildPos = leftChildPos + 1;
            int minChildPos = leftChildPos;

            // is there a right child
            if(rightChildPos < size)
            {
                // which child is smaller
                if(valueAt(rightChildPos) < valueAt(leftChildPos))
                    minChildPos = rightChildPos;
            }

            // if less than children we are done
            // otherwise swap node with smaller child
            if(valueAt(p) <= valueAt(minChildPos))
                break;
            else
            {
                // do the swap
                Integer temp = arrayHeap.get(p);
                arrayHeap.set(p, arrayHeap.get(minChildPos));
                arrayHeap.set(minChildPos, temp);
            }

            // go down to the child position
            p = minChildPos;
        }
    }


    /**
     * The add method adds a value to the heap.
     * @param x The value to add to the heap.
     * @return true
     */
    public boolean add(int x)
    {
        // add x to the end of the array list
        arrayHeap.add(x);

        // sift up
        siftUp();
        return true;
    }


    /**
     * The removeMin method removes an item from the heap.
     * @return The minimum element in the heap.
     * @exception RuntimeException When Priority Queue is empty
     */
    public int removeMin()
    {
        if(isEmpty())
        {
            String message = "Priority Queue is empty";
            throw new RuntimeException(message);
        }
        else
        {
            int val = arrayHeap.get(0);

            // replace root with last leaf
            int lastPos = arrayHeap.size()-1;
            arrayHeap.set(0, arrayHeap.get(lastPos));

            // remove the last leaf
            arrayHeap.remove(arrayHeap.size()-1);
            siftDown();
            return val;
        }
    }


    /**
     * The isEmpty method checks whether the heap is empty.
     * @return true if the heap is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return arrayHeap.size() == 0;
    }


    /**
     * The valueAt method is a convenience method,
     * it makes the code more readable.
     * @param pos The position to return the value for.
     * @return Value stored at a given position in the heap.
     */
    private int valueAt(int pos)
    {
        return arrayHeap.get(pos);
    }
}
