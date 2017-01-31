/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/01/2017.
 */
import java.util.ArrayList;

public class MyList<T extends Number>
{
    public T[] numbers;

    /**
     * Default no-args constructor
     */
    public MyList(T[] numbers)
    {
        this.numbers = numbers;
    }


    /**
     * Numbers does not implement the Comparable Interface and the < operator
     * only works with primitive types so I used a workaround to cast any number
     * passed to be compared into the largest available number type
     * @return The largest value in the array
     */
    public T highest()
    {
        T max = numbers[0];

        for(int i=1; i<numbers.length; i++)
        {
            if( Double.parseDouble(numbers[i].toString()) >  Double.parseDouble((max.toString())) )
            {
                max = numbers[i];
            }
        }

        return max;
    }


    /**
     * Numbers does not implement the Comparable Interface and the > operator
     * only works with primitive types so I used a workaround to cast any number
     * passed to be compared into the largest available number type
     * @return The smallest value in the array
     */
    public T lowest()
    {
        T min = numbers[0];

        for(int i=0; i<numbers.length; i++)
        {
            if( Double.parseDouble(numbers[i].toString()) < Double.parseDouble((min.toString())) )
            {
                min = numbers[i];
            }
        }

        return min;
    }


    /**
     * Note the Number object cannot accept the + operator either
     * @return
     */
    public Double total()
    {
        Double total = 0.0;

        for(int i=0; i<numbers.length; i++)
        {
            total = Double.parseDouble(numbers[i].toString()) + Double.parseDouble((total.toString()));
        }

        return total;
    }


    /**
     * Note the Number object cannot accept the + operator either
     * @return
     */
    public Double average()
    {
        return (total() / numbers.length);
    }
}
