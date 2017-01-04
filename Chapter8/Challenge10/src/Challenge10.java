/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   17/11/2016.
 */
public class Challenge10
{
    private static int getTotal(int[] arr)
    {
        int total = 0;

        for(int i : arr)
            total += i;

        return total;
    }

    private static int getAverage(int[] arr)
    {
        int total = 0;

        for(int i : arr)
            total += i;

        return total/arr.length;
    }

    private static int getHighest(int[] arr)
    {
        int highest = arr[0];

        for(int i : arr)
        {
            if(i > highest)
                highest=i;
        }

        return highest;
    }

    private static int getLowest(int[] arr)
    {
        int lowest = arr[0];

        for(int i : arr)
        {
            if(i < lowest)
                lowest=i;
        }

        return lowest;
    }


    public static void main(String[] args) {
        int[] testArray = {22, 41, 67, 23, 42,
                           92, 86, 17, 22, 31};

        System.out.println("Total = " + getTotal(testArray));
        System.out.println("Average = " + getAverage(testArray));
        System.out.println("Highest number = " + getHighest(testArray));
        System.out.println("Lowest number = " + getLowest(testArray));
    }
}
