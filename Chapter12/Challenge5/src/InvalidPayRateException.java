/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */
public class InvalidPayRateException extends Exception
{
    public InvalidPayRateException()
    {
        super("Error - Payrate must be in the range 0 through 25");
    }
}
