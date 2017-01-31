/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/01/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileParser
{

    /**
     * The static method parseFileToStringArray read the lines from a text file and
     * puts them into the String array passed to it. It returns the length of the array
     * @param filename The name of the file to parse
     * @return Length of the String array
     * @throws IOException
     */
    public static String[] parseFileToStringArray(String filename) throws IOException
    {
        String line;
        List<String> temp = new ArrayList<String>();
        BufferedReader inputFile = new BufferedReader(new FileReader(filename));

        line = inputFile.readLine();

        while (line!=null) {
            temp.add(line.trim());
            line = inputFile.readLine();
        }

        String[] array = new String[temp.size()];

        for(int i=0; i<temp.size(); i++)
            array[i] = new String(temp.get(i).toString());

        return array;
    }
}
