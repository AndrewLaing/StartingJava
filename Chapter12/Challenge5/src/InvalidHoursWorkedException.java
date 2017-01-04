/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */
public class InvalidHoursWorkedException extends Exception
{
    public InvalidHoursWorkedException()
    {
        super("Error - Hours worked must be in the range 0 through 84");
    }
}
