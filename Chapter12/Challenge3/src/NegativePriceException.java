/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class NegativePriceException extends Exception
{
    public NegativePriceException()
    {
        super("Error - negative price entered");
    }
}
