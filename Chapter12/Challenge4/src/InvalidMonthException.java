/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class InvalidMonthException extends Exception
{
    public InvalidMonthException(int month)
    {
        super("Error - invalid month value entered '" + month + "'");
    }

    public InvalidMonthException(String month)
    {
        super("Error - invalid month value entered '" + month + "'");
    }
}
