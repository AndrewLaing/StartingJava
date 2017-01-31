/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   16/01/2017.
 */
public class Challenge7
{
    public static int power(int number, int exp)
    {
        // two base cases
        if(exp==0)
            return 1;
        else if(exp==1)
            return number;

        // recursive case
        number *= power(number, exp-1);

        return number;
    }


    public static void main(String[] args)
    {
        int number = 9;
        int exp = 2;

        System.out.println(number + " power " + exp + " = " + power(number,exp));
    }
}
