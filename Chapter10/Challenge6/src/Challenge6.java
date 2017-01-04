/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/12/2016.
 */

import javax.swing.JOptionPane;

public class Challenge6
{
    public static String[] name = {"Harrison, Rose",
                                    "James, Jean",
                                    "Smith, William",
                                    "Smith, Brad" };

    public static String[] phoneNo = {"555-2234",
                                    "555-9098",
                                    "555-1785",
                                    "555-9224" };

    public static String getSearchResults(String query)
    {
        String searchResult = "";

        for(int i=0; i<name.length; i++)
        {
            if(name[i].startsWith(query)) {
                searchResult += name[i] + ": " + phoneNo[i] + "\n";
            }
        }

        if(searchResult.length() == 0)
            searchResult = "No results found.";

        return searchResult;
    }


    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Enter the name to search for");

        String result = getSearchResults(input);
        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}
