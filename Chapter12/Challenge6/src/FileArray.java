/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */

import java.io.*;

public class FileArray
{
    public static void writeArray(String fileName, char[] charArray) throws IOException
    {
        int rawData;
        FileWriter fwrite = new FileWriter(fileName);

        for(int i=0; i<charArray.length; i++)
        {
            rawData = (int) charArray[i];
            fwrite.write(rawData);
        }
        fwrite.close();
    }


    public static void readArray(String fileName, char[] charArray) throws IOException
    {
        int rawData;
        FileReader freader = new FileReader(fileName);
        StringBuffer temp = new StringBuffer();

        rawData = freader.read();
        int i=0;
        while(rawData!=-1)
        {
            temp.append((char)rawData);
            rawData = freader.read();
        }
        freader.close();


        int bufferLength = temp.length();
        char[] copy = new char[bufferLength];

        for(int j=0; j<bufferLength; j++) {
            copy[j] = temp.charAt(j);
        }

        for(int j=0; j<bufferLength && j<charArray.length; j++) {
            charArray[j] = copy[j];
        }
    }

}
