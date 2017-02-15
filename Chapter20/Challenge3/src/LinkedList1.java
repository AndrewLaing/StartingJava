/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   07/02/2017.
 */
public class LinkedList1
{
    /**
     * The Node class represents a list node
     */
    private class Node
    {
        String value;
        Node next;

        /**
         * Constructor
         * @param val The element to store in this node
         * @param n The reference to the next node
         */
        Node(String val, Node n)
        {
            value = val;
            next = n;
        }


        /**
         * Constructor
         * @param val The element to store in this node
         */
        Node(String val)
        {
            // call the other (sister) constructor
            this(val, null);
        }
    }

    private Node first = null;      // list head
    private Node last = null;       // last element in list


    /**
     * Constructor
     */
    public LinkedList1()
    {
        first = null;
        last = null;
    }


    /**
     * The reverse method reverses the elements in the linked list
     */
    public void reverse()
    {
        if(size() < 2)
            return;

        first = reverse(first);

        // Find and set the new last node
        Node p = first;
        while(p.next != null)
            p = p.next;

        last = p;
    }


    private Node reverse(Node list)
    {
        int indexOfLast = size()-1;

        // Base case - turn the previously first node into the last one
        if(indexOfLast == 0)
        {
            list.next = null;
            return list;
        }

        // Remove the last element from the list
        Node newFirst = new Node(remove(indexOfLast));

        // Attach the new last node as the next one
        newFirst.next = reverse(first);

        // Return the first Node
        return newFirst;
    }


    /**
     * The sort method recursively sorts the linked list
     * using a variation of a Selection Sort algorithm
     */
    public void sort()
    {
        if(size()>1)
            sort(first);
    }


    /**
     * The private sort method recursively swaps the smallest
     * element with the element at the front of the list until
     * the end of the list is reached
     * @param list A list to sort
     */
    private void sort(Node list)
    {
        String temp;
        Node p = list;

        while(p.next!=null)
        {
            p = p.next;

            if(p.value.compareTo(list.value) < 0)
            {
                temp = list.value;
                list.value = p.value;
                p.value = temp;
            }
        }

        if(list.next!=null)
            sort(list.next);
    }


    public String get(int index)
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


    public String set(int index, String element)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        String oldValue = p.value;
        p.value = element;
        return oldValue;
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
    public void add(String e)
    {
        if(isEmpty())
        {
            first = new Node(e);
            last = first;
        }
        else
        {
            // add to end of the existing list
            last.next = new Node(e);
            last = last.next;
        }
    }



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
            first = new Node(e, first);

            if(last==null)
                last = first;

            return;
        }

        // Set a reference pred to point to the node that will be
        // the predecessor of the new node
        Node pred = first;

        for(int k=1; k<=index-1; k++)
        {
            pred = pred.next;
        }

        // splice in a new node containing the new element
        pred.next = new Node(e, pred.next);

        // Is there a new last element?
        if(pred.next.next == null)
            last = pred.next;
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



    public String remove(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        String element;     // the element to return
        if(index==0)
        {
            // removal of the first item in the list
            element = first.value;
            first = first.next;

            if(first == null)
                last = null;
        }
        else
        {
            // To remove an element other than the first find the
            // predecessor of the element to be removed
            Node pred = first;

            // move pred forward index-1 times
            for(int k=1; k<= index-1; k++)
                pred = pred.next;

            // store the value to return
            element = pred.next.value;

            // route link around the node to be removed
            pred.next = pred.next.next;

            // check if pred is now last
            if(pred.next == null)
                last = pred;
        }
        return element;
    }


    /**
     * The remove method removes an element
     * @param element The element to remove
     * @return true if the remove succeeded, false otherwise
     */
    public boolean remove(String element)
    {
        if(isEmpty())
            return false;

        if(element.equals(first.value))
        {
            // removal of the first item in the list
            first = first.next;
            if(first==null)
                last = null;
            return true;
        }

        // find the predecessor of the element to remove
        Node pred = first;
        while(pred.next != null && !pred.next.value.equals(element))
        {
            pred = pred.next;
        }

        // pred.next==null OR pred.next.value is element
        if(pred.next==null)
            return false;

        // pred.next.value is element
        pred.next = pred.next.next;

        // check if pred is now last
        if(pred.next == null)
            last = pred;

        return true;
    }
}
