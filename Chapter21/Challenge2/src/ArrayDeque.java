/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/02/2017.
 */
public class ArrayDeque
{
    private String[] q;     // holds queue elements
    private int front;      // next item to be removed
    private int rear;       // next slot to fill
    private int size;       // number of items in queue


    /**
     * Constructor
     * @param capacity The capacity of the queue
     */
    ArrayDeque(int capacity)
    {
        q = new String[capacity];
        front = 1;
        rear = 0;
        size = 0;
    }


    /**
     * The capacity method returns the length of
     * the array used to implement the queue
     * @return The capacity of the queue
     */
    public int capacity()
    {
        return q.length;
    }


    /**
     * The empty method checks if this deque is empty
     * @return true if the deque is empty
     *         and false otherwise
     */
    public boolean empty()
    {
        return size==0;
    }


    /**
     * The size method returns the size of the deque
     * @return The size of the deque
     */
    public int size()
    {
        return size;
    }


    /**
     * The addFront method adds an element to the front of the deque
     * @param s The element to be added to the front of the deque
     * @exception DequeOverflowException When there is no more room in the deque
     */
    public void addFront(String s)
    {
        if(size == q.length)
            throw new DequeOverflowException();
        else
        {
            // add to rear of deque
            size++;

            // remove from the rear
            front--;
            if(front < 0)
                front = q.length-1;

            q[front] = s;
        }
    }


    /**
     * The addRear method adds an element to the rear of the deque
     * @param s The element to be added to the rear of the deque
     * @exception DequeOverflowException When there is no more room in the deque
     */
    public void addRear(String s)
    {
        if(size == q.length)
            throw new DequeOverflowException();
        else
        {
            // add to rear of deque
            if(q[front+1]==null)
                rear = front+1;


            size++;
            q[rear] = s;
            rear++;
            if(rear == q.length)
                rear = 0;
        }
    }


    /**
     * The removeFront method returns the item
     * at the front of the deque
     * @return The item at the front of the deque
     * @exception EmptyDequeException the queue is deque
     */
    public String removeFront()
    {
        if(empty())
            throw new EmptyDequeException();
        else
        {
            size--;

            // remove from the front
            String value = q[front];

            // facilitate garbage collection
            q[front]=null;

            // update front
            front++;
            if(front == q.length)
                front = 0;

            return value;
        }
    }


    /**
     * The removeRear method removes and returns the item
     * at the rear of the deque
     * @return The item at the rear of the deque
     * @exception EmptyDequeException the queue is deque
     */
    public String removeRear()
    {
        if(empty())
            throw new EmptyDequeException();
        else
        {
            size--;

            // remove from the rear
            rear--;
            if(rear < 0)
                rear = q.length-1;

            String value = q[rear];

            // facilitate garbage collection
            q[rear]=null;

            return value;
        }
    }


    /**
     * The toString method returns a readable representation
     * of the contents of the deque
     * @return The string representation of the contents of the deque
     */
    public String toString()
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("front = " + front + "; ");
        sBuilder.append("rear = " + rear + "\n");

        for(int k=0; k<q.length; k++)
        {
            if(q[k] != null)
                sBuilder.append(k + " " + q[k]);
            else
                sBuilder.append(k + " ?");
            if(k != q.length)
                sBuilder.append("\n");
        }

        return sBuilder.toString();

    }
}

