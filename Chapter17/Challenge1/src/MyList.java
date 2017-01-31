/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/01/2017.
 */

import java.math.BigDecimal;
import java.util.ArrayList;

public class MyList<T extends Number>
{
    public ArrayList<T> numbers;

    /**
     * Default no-args constructor
     */
    public MyList()
    {
        numbers = new ArrayList<T>();
    }


    public void add(T n)
    {
        numbers.add(n);
    }


    /**
     * Numbers does not implement the Comparable Interface and the < operator
     * only works with primitive types so I used a workaround to cast any number
     * passed to be compared into the largest available number type
     * @return The largest value in the array
     */
    public T largest()
    {
        T largest = numbers.get(0);

        for(int i=1; i<numbers.size(); i++)
        {
            if( Double.parseDouble(numbers.get(i).toString()) >  Double.parseDouble((largest.toString())) )
            {
                largest = numbers.get(i);
            }
        }

        return largest;
    }


    /**
     * Numbers does not implement the Comparable Interface and the > operator
     * only works with primitive types so I used a workaround to cast any number
     * passed to be compared into the largest available number type
     * @return The smallest value in the array
     */
    public T smallest()
    {
        T smallest = numbers.get(0);

        for(int i=0; i<numbers.size(); i++)
        {
            if( Double.parseDouble(numbers.get(i).toString()) < Double.parseDouble((smallest.toString())) )
            {
               smallest  = numbers.get(i);
            }
        }

        return smallest;
    }

}
