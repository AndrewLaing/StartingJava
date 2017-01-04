/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/12/2016.
 */
import java.io.*;
import javax.swing.*;
import java.util.*;

public class Utilities
{
    public static String getOpenFilename() throws IOException
    {
        String filename = "";

        // Get the name of the file to get nGrams for
        JFileChooser getName1 = new JFileChooser();
        int status = getName1.showOpenDialog(null);

        if(status == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = getName1.getSelectedFile();
            filename = selectedFile.getPath();
        }
        else
            return null;

        return filename;
    }


    public static void readFileToLists(String filename, List titles, List prices) throws Exception
    {
        String line;
        BufferedReader inputfile =
                new BufferedReader(new FileReader(filename));

        line = inputfile.readLine();

        while (line != null)
        {
            String[] parts = line.split(",");

            if(parts.length==2)
            {
                titles.add(parts[0].trim());
                prices.add(Double.parseDouble(parts[1].trim()));
            }

            line = inputfile.readLine();
        }

        inputfile.close();
    }

}

