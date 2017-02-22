/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/02/2017.
 */
public class GenLinkedStack<E>
{
    /**
     * The Node class is used to implement the linked list
     */
    private class Node
    {
        E value;
        Node next;
        Node(E value, Node n)
        {
            this.value = value;
            this.next = n;
        }
    }

    public Node top = null;


    public GenLinkedStack()
    {
    }


    /**
     * The empty method checks for an empty stack
     * @return true if the stack is empty
     */
    public boolean empty()
    {
        return top==null;
    }


    /**
     * The size method returns the number of elements in the stack
     * @return The number of elements in the stack.
     */
    public int size()
    {
        if(empty())
            return 0;

        int count = 0;
        Node p = top;
        while(p!=null)
        {
            count++;
            p = p.next;
        }

        return count;
    }


    public void clear()
    {
        while(top!=null)
            pop();
    }


    /**
     * The push method adds a new item to the stack
     * @param element The item to be pushed onto the stack
     */
    public void push(E element)
    {
        top = new Node(element, top);
    }


    /**
     * The pop method removes the value at the top of the stack
     * @return The value at the top of the stack
     * @exception EmptyStackException When the stack is empty
     */
    public E pop()
    {
        if(empty())
            throw new EmptyStackException();
        else
        {
            E retValue = top.value;
            top = top.next;
            return retValue;
        }
    }


    /**
     * The peek method returns the element at the top of the stack
     * @return The element at the top of the stack
     * @exception EmptyStackException When the stack is empty
     */
    public E peek()
    {
        if(empty())
            throw new EmptyStackException();
        else
        {
            return top.value;
        }
    }


    /**
     * The toString method computes a string representation
     * of the contents of the stack
     * @return The string representation of the stack contents
     */
    public String toString()
    {
        StringBuilder sBuilder = new StringBuilder();
        Node p = top;
        while(p!=null)
        {
            sBuilder.append(p.value);
            p = p.next;
            if(p!=null)
                sBuilder.append("\n");
        }

        return sBuilder.toString();
    }

}
