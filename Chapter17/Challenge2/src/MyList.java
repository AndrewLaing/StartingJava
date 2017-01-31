/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/01/2017.
 */

import java.math.BigDecimal;
import java.util.ArrayList;

public class MyList<T extends Comparable>
{
    public ArrayList<T> listItems;

    /**
     * Default no-args constructor
     */
    public MyList()
    {
        listItems = new ArrayList<T>();
    }


    public void add(T n)
    {
        listItems.add(n);
    }


    public T largest()
    {
        T largest = listItems.get(0);

        for(int i=1; i<listItems.size(); i++)
        {
            if( listItems.get(i).compareTo(largest) > 0 )
            {
                largest = listItems.get(i);
            }
        }

        return largest;
    }


    public T smallest()
    {
        T smallest = listItems.get(0);

        for(int i=0; i<listItems.size(); i++)
        {
            if( listItems.get(i).compareTo(smallest) < 0 )
            {
               smallest  = listItems.get(i);
            }
        }

        return smallest;
    }

}
