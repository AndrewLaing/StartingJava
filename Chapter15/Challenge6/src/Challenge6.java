/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   16/01/2017.
 */
public class Challenge6
{
    public static int charCounter(String str, char c, int counter)
    {
        if(str.length()==1) {
            if(str.charAt(0)==c)
                counter++;
        }
        else {
            if(str.charAt(0)==c)
                counter++;
            counter = charCounter(str.substring(1), c, counter);
        }

        return counter;
    }


    public static void main(String[] args)
    {
        String str = "this is the amazing string";
        char c = 'i';
        int count = 0;

        System.out.println("Character count = " + charCounter(str, c, count));

    }
}
