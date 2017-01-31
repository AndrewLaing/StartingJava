/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/01/2017.
 */


public class MyList<T extends Comparable>
{
    private T[] array;

    public MyList(T[] array)
    {
        this.array = array;
    }


    public T highest()
    {
        T max = array[0];

        for(int i=1; i<array.length; i++)
        {
            if( array[i].compareTo(max) > 0 )
            {
                max = array[i];
            }
        }

        return max;
    }


    public T lowest()
    {
        T min = array[0];

        for(int i=0; i<array.length; i++)
        {
            if( array[i].compareTo(min) < 0 )
            {
                min  = array[i];
            }
        }

        return min;
    }
}