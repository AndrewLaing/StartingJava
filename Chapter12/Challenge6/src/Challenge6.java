import java.io.IOException;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */
public class Challenge6
{
    public static void main(String[] args) throws IOException
    {
        char[] toWrite = {'A',' ','s','i','m','p','l','e',' ','t','e','s','t','.'};
        FileArray.writeArray("testFile.txt", toWrite);

        char[] toRead = new char[50];
        FileArray.readArray("testFile.txt", toRead);

        String result = new String(toRead);
        System.out.print("Result = " + result);

    }
}
