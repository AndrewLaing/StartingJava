/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   15/01/2017.
 */
public class Challenge4
{
    public static int maxElement(int[] array, int position, int max)
    {
        if(position>=array.length)
            return max;
        else if(array[position] > max)
            max = array[position];

        max = maxElement(array, position+1, max);
        return max;
    }


    public static void main(String[] args)
    {
        int[] array = new int[]{45,65,2,24,33,48,61};
        int position = 0;
        int max = 0;

        max = maxElement(array, position, max);

        System.out.println("MAX = " + max);

    }
}
