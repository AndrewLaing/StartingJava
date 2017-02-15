/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */

import java.util.*;

public class Challenge5
{
    public static boolean isPrime(int testNumber)
    {
        int max = (int)Math.ceil(Math.sqrt(testNumber));

        if(testNumber<1) return false;     // negative numbers can not be prime
        if(testNumber<4) return true;      // 1,2 and 3 are primes
        if(testNumber%2==0) return false;  // all even numbers > 2 are not primes

        // All even numbers have been eliminated in the previous statement
        for(int i=3; i<=max; i+=2)
        {
            if(testNumber%i==0)
                return false;
        }

        return true;
    }



    public static void main(String[] args)
    {
        List<Integer> primes = new LinkedList<Integer>();
        int count = 0;
        int n=0;

        while(count < 100)
        {
            n++;
            if(isPrime(n)) {
                primes.add(n);
                count++;
            }
        }

        Iterator it = primes.listIterator();

        while(it.hasNext())
            System.out.println(it.next());

    }
}
