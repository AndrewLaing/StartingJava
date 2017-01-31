import javax.sound.midi.SysexMessage;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   15/01/2017.
 */
public class Challenge2
{
    public static int counter = 0;

    /*
     * Note: the problem with this method is that the counter mus
     */
    public static boolean isMember(int[] array, int value)
    {
        // if all elements of the array have been examined return false
        // because the value has not been found
        if(counter==array.length)
        {
            counter = 0;    // reset the counter
            return false;
        }
        else if(array[counter]==value)
        {
            counter = 0;    // reset the counter
            return true;
        }
        // examine the next element of the array recursively
        else
        {
            counter++;      // augment the counter
            return isMember(array, value);
        }

    }


    public static void main(String[] args) {
        int[] x = new int[] {1,2,9,4,3};
        int y = 3;

        if(isMember(x, y))
        {
            System.out.println("IS a member.");
        }
        else
        {
            System.out.println("IS NOT a member.");
        }

        y = 7;

        if(isMember(x, y))
        {
            System.out.println("IS a member.");
        }
        else
        {
            System.out.println("IS NOT a member.");
        }

    }
}
