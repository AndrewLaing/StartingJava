/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/02/2017.
 */
public class GenericDLinkedList<E>
{
    /**
     * The Node class represents a list node
     */
    private class Node
    {
        E value;
        Node next;
        Node prev;

        /**
         * Constructor
         * @param val The element to store in this node
         * @param n The reference to the successor node
         * @param p The reference to the predecessor node
         */
        Node(E val, Node n, Node p)
        {
            value = val;
            next = n;
            prev = p;
        }


        /**
         * Constructor
         * @param val The element to store in this node
         */
        Node(E val)
        {
            // call the other (sister) constructor
            this(val, null, null);
        }
    }

    private Node first = null;      // list head
    private Node last = null;       // last element in list


    /**
     * Constructor
     */
    public GenericDLinkedList()
    {
        first = null;
        last = null;
    }


    /**
     * The method isEmpty checks to see if the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return first==null;
    }


    /**
     * The method size returns the length of the list
     * @return The number of elements in the list
     */
    public int size()
    {
        int count = 0;
        Node p = first;

        while(p!=null)
        {
            // there is an element at p
            count++;
            p = p.next;
        }

        return count;
    }


    /**
     * The add method adds an element to the end of the list
     * @param e The value to add to the end of the list
     */
    public void add(E e)
    {
        if(isEmpty())
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



    public void add(int index, E e)
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
     * The clear method removes all items from the list
     */
    public void clear()
    {
        for(int index=size()-1; index>=0; index--)
            remove(index);

        first = null;
        last = null;
    }


    /**
     * The get method returns the element at index
     * @param index The index of the element to return
     * @return The element at the specified index
     * @exception IndexOutOfBoundsException When the index is out of bounds
     */
    public E get(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        return p.value;
    }

    /**
     * The toString method computes the string representation of the list
     * @return The string form of the list
     */
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        // use p to walk down the Linked List
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
    public E remove(int index)
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

        E element = target.value;      // the element to return
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
    public boolean remove(E element)
    {
        if(isEmpty())
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


    public E set(int index, E element)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        E oldValue = p.value;
        p.value = element;
        return oldValue;
    }
}