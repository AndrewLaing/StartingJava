/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */
public class EmptyNameException extends Exception
{
    public EmptyNameException()
    {
        super("Error - name field must be completed");
    }
}
