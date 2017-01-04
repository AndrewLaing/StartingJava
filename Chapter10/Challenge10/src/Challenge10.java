/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/12/2016.
 */

import javax.swing.*;
import java.io.*;

public class Challenge10
{

    public static int wordCount(String filename) throws IOException
    {
        String line, temp;
        String array[];
        int wc = 0;

        FileReader freader = new FileReader(filename);
        BufferedReader input = new BufferedReader(freader);

        line = input.readLine();

        while(line != null)
        {
            line = line.replaceAll("[!?,]", " "); // first replace all other word delimiters
            array = line.split(" ");

            for(int i=0; i<array.length; i++)
            {
                temp = array[i].trim();

                if(temp.length()>0)
                    wc ++;
            }



            line = input.readLine();
        }

        input.close();

        return wc;
    }

    public static void main(String[] args) throws IOException
    {
        String filename;

        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(null);

        if(status == JFileChooser.APPROVE_OPTION)
        {
            File selectedPath = fileChooser.getSelectedFile();
            filename = selectedPath.getPath();
            JOptionPane.showMessageDialog(null, "The file contains - " + wordCount(filename) + " words.");
            wordCount(filename);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Aborted.");
        }

        System.exit(0);
    }
}
