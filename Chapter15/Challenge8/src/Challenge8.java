/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   16/01/2017.
 */
public class Challenge8
{
    public static int sumOfNumbers(int number)
    {
        // two base cases
        if(number==0)
            return number;
        else if(number==1)
            return number;

        // recursive case
        number += sumOfNumbers(number-1);

        return number;
    }

    public static void main(String[] args)
    {
        int number = 5;
        System.out.println("Sum of numbers " + number + " = " + sumOfNumbers(number));
    }
}
