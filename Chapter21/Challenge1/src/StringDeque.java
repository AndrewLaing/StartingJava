/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/02/2017.
 */
public class StringDeque
{

    /**
     * The Node class represents a deque node
     */
    private class Node
    {
        String value;
        Node next;
        Node prev;

        /**
         * Constructor
         * @param val The element to store in this node
         * @param n The reference to the successor node
         * @param p The reference to the predecessor node
         */
        Node(String val, Node n, Node p)
        {
            value = val;
            next = n;
            prev = p;
        }


        /**
         * Constructor
         * @param val The element to store in this node
         */
        Node(String val)
        {
            // call the other (sister) constructor
            this(val, null, null);
        }
    }

    private Node first = null;      // deque head
    private Node last = null;       // last element in deque


    /**
     * Constructor
     */
    public StringDeque()
    {
        first = null;
        last = null;
    }


    /**
     * The method isEmpty checks to see if the deque is empty
     * @return true if the deque is empty, false otherwise
     */
    public boolean empty()
    {
        return first==null;
    }


    /**
     * The method size returns the length of the deque
     * @return The number of elements in the deque
     */
    public int size()
    {
        int count = 0;
        Node p = first;

        while(p!=null)
        {
            count++;
            p = p.next;
        }

        return count;
    }


    /**
     * The addFront method adds an element to the front of the deque
     * @param e The value to add to the front of the deque
     */
    public void addFront(String e)
    {
        if(empty())
        {
            first = new Node(e);
            last = first;
        }
        else
        {
            Node p = first;                 // create a reference to the current first
            first = new Node(e, p, null);   // set new first (value, next, prev)

            if(p != null)
                p.prev = first;             // set prev in old first to point to new first
            if(last==null)
                last = first;

            return;
        }
    }


    /**
     * The addRear method adds an element to the end of the deque
     * @param e The value to add to the end of the deque
     */
    public void addRear(String e)
    {
        if(empty())
        {
            first = new Node(e);
            last = first;
        }
        else
        {
            // add to end of the existing list
            last.next = new Node(e, null, last);
            last = last.next;
        }
    }


    /**
     * The removeFront method removes the value at the front
     * of the deque
     * @return The value at the front of the deque
     * @exception EmptyDequeException When the deque is empty
     */
    public String removeFront()
    {
        if(empty())
            throw new EmptyDequeException();
        else
        {
            String retValue = first.value;
            first = first.next;

            if(first!=null)
                first.prev = null;

            if(first==null)
                last=null;

            return retValue;
        }
    }


    /**
     * The removeRear method removes the value at the end
     * of the deque
     * @return The value at the end of the deque
     * @exception EmptyDequeException When the deque is empty
     */
    public String removeRear()
    {
        if(empty())
            throw new EmptyDequeException();
        else
        {
            String retValue = last.value;
            last = last.prev;
            if(last!=null)
                last.next = null;

            if(last==null)
                first=null;

            return retValue;
        }
    }


    /**
     * The add method adds an item at a specified index
     * @param index Index to add the item at
     * @param e The item to add
     * @exception IndexOutOfBoundsException When the index is out of bounds
     */
    public void add(int index, String e)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        if(index == 0)
        {
            //  new element goes at the beginning
            Node p = first;                 // old first
            first = new Node(e, p, null);

            if(p != null)
                p.prev = first;
            if(last==null)
                last = first;

            return;
        }

        // pred will point to the predecessor of the new node
        Node pred = first;

        for(int k=1; k<=index-1; k++)
        {
            pred = pred.next;
        }

        // splice in a node with the new element
        // we want to go from pred-- succ to pred--middle--succ
        Node succ = pred.next;
        Node middle = new Node(e, succ, pred);
        pred.next = middle;
        if(succ==null)
            last=middle;
        else
            succ.prev=middle;
    }


    /**
     * The toString method computes the string representation of the deque
     * @return The string form of the deque
     */
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        // use p to walk down the deque
        Node p = first;

        while(p!=null)
        {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }

        return strBuilder.toString();
    }


    /**
     * The remove method removes the element at a given position
     * @param index The position of the element to remove
     * @return The element removed
     * @exception IndexOutOfBoundsException When index is out of bounds
     */
    public String remove(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Locate the node targeted for removal
        Node target = first;
        for(int k=1; k<=index; k++)
            target = target.next;

        String element = target.value;      // the element to return
        Node pred = target.prev;            // Node before the target
        Node succ = target.next;            // Node after the target

        // route forward and back pointers around the node to be removed
        if(pred==null)
            first = succ;
        else
            pred.next = succ;

        if(succ==null)
            last=pred;
        else
            succ.prev = pred;

        return element;
    }


    /**
     * The remove method removes an element
     * @param element The element to remove
     * @return true if the remove succeeded, false otherwise
     */
    public boolean remove(String element)
    {
        if(empty())
            return false;

        // find the predecessor of the element to remove
        Node target = first;
        while(target!=null && !element.equals(target.value))
        {
            target = target.next;
        }

        Node pred = target.prev;            // Node before the target
        Node succ = target.next;            // Node after the target

        // route forward and back pointers around the node to be removed
        if(pred==null)
            first = succ;
        else
            pred.next = succ;

        if(succ==null)
            last=pred;
        else
            succ.prev = pred;

        return true;
    }
}
