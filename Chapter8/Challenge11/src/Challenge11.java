/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   17/11/2016.
 */

import java.io.*;

public class Challenge11
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


    public static void main(String[] args) throws IOException
    {
        int[] testArray = new int[10];
        FileReader freader = new FileReader("data.txt");
        BufferedReader input = new BufferedReader(freader);

        String line = input.readLine();

        int subscript = 0;
        while(line!=null)
        {
            testArray[subscript] = Integer.parseInt(line);
            subscript++;
            line = input.readLine();
        }

        input.close();

        System.out.println("Lowest number = " + getLowest(testArray));
        System.out.println("Highest number = " + getHighest(testArray));
        System.out.println("Total = " + getTotal(testArray));
        System.out.println("Average = " + getAverage(testArray));

    }
}
