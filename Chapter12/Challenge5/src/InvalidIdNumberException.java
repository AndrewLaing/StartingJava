/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */
public class InvalidIdNumberException extends Exception
{
    public InvalidIdNumberException()
    {
        super("Error - ID Number must be greater than zero");
    }
}
