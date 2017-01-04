/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */

import java.io.*;


public class Encrypt
{
    public static void encrypt(String fileName) throws IOException
    {
        int rawData;
        String outputFile = fileName + ".enc";

        FileReader freader = new FileReader(fileName);
        FileWriter fwrite = new FileWriter(outputFile);

        rawData = freader.read();

        while(rawData!=-1)
        {
            if (rawData!=-1)
            {
                rawData+=10;
                fwrite.write(rawData);
            }
            rawData = freader.read();
        }
        freader.close();
        fwrite.close();
    }


    public static void decrypt(String fileName) throws IOException
    {
        int rawData;
        String outputFile = fileName + ".dec";

        FileReader freader = new FileReader(fileName);
        FileWriter fwrite = new FileWriter(outputFile);

        rawData = freader.read();

        while(rawData!=-1)
        {
            if (rawData!=-1)
            {
                rawData-=10;
                fwrite.write(rawData);
            }
            rawData = freader.read();
        }
        freader.close();
        fwrite.close();
    }



}
