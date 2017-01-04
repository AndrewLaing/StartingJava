/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   17/11/2016.
 */
public class Challenge12
{
    private static int getTotal(int[][] arr)
    {
        int total = 0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
                total += arr[i][j];
        }

        return total;
    }

    private static int getAverage(int[][] arr)
    {
        int total = 0;

        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
                total += arr[i][j];
        }
        return total/(arr.length * arr[0].length);
    }

    private static int getRowTotal(int[][] arr, int rowNum)
    {
        int total = 0;

        for(int i=0; i<arr[0].length; i++)
            total += arr[rowNum][i];

        return total;
    }

    private static int getColumnTotal(int[][] arr, int colNum)
    {
        int total = 0;

        for(int i=0; i<arr.length; i++)
            total += arr[i][colNum];

        return total;
    }

    private static int getHighestInRow(int[][] arr, int rowNum)
    {
        int highest = arr[rowNum][0];

        for(int i=0; i<arr[rowNum].length; i++)
        {
            if(arr[rowNum][i]>highest)
                highest = arr[rowNum][i];
        }
        return highest;
    }

    private static int getLowestInRow(int[][] arr, int rowNum)
    {
        int lowest = arr[rowNum][0];

        for(int i=0; i<arr[rowNum].length; i++)
        {
            if(arr[rowNum][i]<lowest)
                lowest = arr[rowNum][i];
        }
        return lowest;
    }


    public static void main(String[] args)
    {
        int[][] testArray = {{9,  6, 12, 22},
                             {24, 7,  3,  8},
                             {21, 9, 11, 11}};

        System.out.println("Total = "   + getTotal(testArray));
        System.out.println("Average = " + getAverage(testArray));
        System.out.println("Total of row 2 = " + getRowTotal(testArray, 2));
        System.out.println("Total of column 1 = " + getColumnTotal(testArray, 1));
        System.out.println("Highest in row 2 = " + getHighestInRow(testArray, 2));
        System.out.println("Lowest in row 0 = " + getLowestInRow(testArray, 0));
    }
}
