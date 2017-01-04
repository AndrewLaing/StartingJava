/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class InvalidTestScore extends Exception
{
    public InvalidTestScore(int score)
    {
        super("Error - Invalid test score entered: " + score);
    }
}
