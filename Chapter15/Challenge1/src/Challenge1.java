/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   15/01/2017.
 */
public class Challenge1
{

    public static int muliply(int x, int y)
    {
        if(x<=0)
            return 0;
        else
            return y + (muliply(x-1, y));
    }


    public static void main(String[] args)
    {
        int x=3, y=4;
        System.out.println(x + " * " + y + " = " + muliply(x,y));
    }
}
