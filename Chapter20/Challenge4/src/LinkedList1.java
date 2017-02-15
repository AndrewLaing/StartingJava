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
        String name;
        int score;
        Node next;

        /**
         * Constructor
         * @param name The name of the performer
         * @param score The performer's score
         * @param n The reference to the next node
         */
        Node(String name, int score, Node n)
        {
            this.name = name;
            this.score = score;
            next = n;
        }


        /**
         * Constructor
         * @param name The name of the performer
         * @param score The performer's score
         */
        Node(String name, int score)
        {
            // call the other (sister) constructor
            this(name, score, null);
        }
    }

    private Node first = null;      // list head
    private Node last = null;       // last element in list

    private final int MAX_PLAYERS = 10;


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
        if(size()<2)
            return;

        Node tempFirst = new Node(last.name, last.score);
        Node p = tempFirst;
        for(int i=size()-2; i>=0; i--)
        {
            Node temp = remove(i);
            p.next = new Node(temp.name, temp.score);
            p = p.next;
        }

        first = tempFirst;
        last = p;
    }


    /**
     * The sort method uses the bubble sort algorithm to sort
     * the Linked List in descending order of score
     */
    public void sort()
    {
        if(size()<2)
            return;

        int maxElement;
        int index;
        String tempName, tempName1;
        int tempScore, tempScore1;


        for(maxElement=size()-1; maxElement>=0; maxElement--)
        {
            for (index = 0; index<=maxElement-1; index++)
            {
                if (getScore(index) < getScore(index+1))
                {
                    tempName = getName(index);
                    tempScore = getScore(index);

                    tempName1 = getName(index+1);
                    tempScore1 = getScore(index+1);

                    // Swap the attributes of the two nodes
                    set(index, tempName1, tempScore1);
                    set(index+1, tempName, tempScore);
                }
            }
        }
    }


    /**
     * The method getName returns the name attribute of the element at
     * the specified index
     * @param index The index of the element to get the name for
     * @return The name attribute of the element at the specified index
     */
    public String getName(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        return p.name;
    }


    /**
     * The method getScore returns the score attribute of the element at
     * the specified index
     * @param index The index of the element to get the score for
     * @return The score attribute of the element at the specified index
     */
    public int getScore(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        return p.score;
    }


    /**
     * The method getName returns the node at the specified index
     * @param index The index of the node
     * @return The Node at the specified index
     */
    public Node getNode(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        return p;
    }


    public Node set(int index, String name, int score)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node p = first;
        for(int i=0; i<index; i++)
            p = p.next;

        int oldScore = p.score;
        String oldName = p.name;

        p.name = name;
        p.score = score;


        Node oldNode = new Node(oldName, oldScore);

        return oldNode;
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


    public void insert(String name, int score) {
        add(name, score);
    }


    /**
     * The add method adds an element to the end of the list
     * @param name The name of the performer
     * @param score The performer's score
     */
    public void add(String name, int score)
    {
        if(isEmpty())
        {
            first = new Node(name, score);
            last = first;
        }
        else
        {
            // If the list is full ignore scores under the lowest or remove
            // the lowest score to make room for the new score
            if(size()>=MAX_PLAYERS)
            {
                if(score < last.score)
                    return;
                else
                    remove(MAX_PLAYERS-1);
            }

            last.next = new Node(name, score);
            last = last.next;
        }

        sort();
    }


    /**
     * The add method adds an element to the specified index
     * @param index The index to add the new nod at
     * @param name The name of the performer
     * @param score The performer's score
     */
    public void add(int index, String name, int score)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // If the list is full ignore scores under the lowest or remove
        // the lowest score to make room for the new score
        if(size()>=MAX_PLAYERS)
        {
            if(score < last.score)
                return;
            else
                remove(MAX_PLAYERS-1);
        }

        // Index is at least 0
        if(index == 0)
        {
            //  new element goes at the beginning
            first = new Node(name, score, first);

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

        // splice in a new node containing the new performer
        pred.next = new Node(name, score, pred.next);

        // Is there a new last element?
        if(pred.next.next == null)
            last = pred.next;


        // The list MUST be sorted
        sort();
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

        int count = 1; // Used to show the performer's position in the top ten

        while(p!=null)
        {
            strBuilder.append(count++ + " - " + p.name + ": " + p.score + "\n");
            p = p.next;
        }

        return strBuilder.toString();
    }



    public Node remove(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node removed;

        if(index==0)
        {
            // removal of the first item in the list
            removed = new Node(first.name, first.score);
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
            removed = new Node(pred.next.name, pred.next.score);

            // route link around the node to be removed
            pred.next = pred.next.next;

            // check if pred is now last
            if(pred.next == null)
                last = pred;
        }
        return removed;
    }


    /**
     * The remove method removes an element
     * @param name The name of the performer to remove
     * @return true if the remove succeeded, false otherwise
     */
    public boolean remove(String name)
    {
        if(isEmpty())
            return false;

        if(name.equals(first.name))
        {
            // removal of the first item in the list
            first = first.next;
            if(first==null)
                last = null;
            return true;
        }

        // find the predecessor of the element to remove
        Node pred = first;
        while(pred.next != null && !pred.next.name.equals(name))
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
