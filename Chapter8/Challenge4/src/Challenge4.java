/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   10/11/2016.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.io.*;


public class Challenge4
{

    private static ArrayList<String> ACCOUNTS = new ArrayList<String>();

    /**
     * The method readFileIntoArrayList() reads the contents of account.txt
     * into the ACCOUNTS ArrayList
     * @throws IOException
     */
    private static void readFileIntoArrayList() throws IOException
    {
        String line;    // to hold a line of input

        // Open the file
        FileReader freader = new FileReader("accounts.txt");
        BufferedReader fileInput = new BufferedReader(freader);

        line = fileInput.readLine();
        while(line != null) {
            ACCOUNTS.add(line);
            line = fileInput.readLine();
        }

        // Close the file
        fileInput.close();
    }


    /**
     * The method sequentialSearch searches the ACCOUNTS ArrayList for the
     * account number passed to it
     * @param testNo An account number to look for in the ACCOUNTS ArrayList
     * @return True if the account number is in the ArrayList, otherwise false
     */
    private static boolean sequentialSearch(String testNo)
    {
        if(testNo.length() != ACCOUNTS.get(0).length())
            return false;

        for(int i=0; i < ACCOUNTS.size(); i++)
        {
            if(testNo.equals( ACCOUNTS.get(i) ))
                return true;
        }

        return false;
    }


    public static void main(String[] args) throws IOException
    {

        // Read the contents of account.txt into the ACCOUNTS ArrayList
        readFileIntoArrayList();

        String input;
        boolean isValidAccount = false;

        // Get the user to input a valid integer for the account number
        input = JOptionPane.showInputDialog("Please enter the account number");

        // Test the account number entered and show a suitable message
        isValidAccount = sequentialSearch(input);

        if(isValidAccount)
            JOptionPane.showMessageDialog(null, "You have entered a valid account number. Please proceed.");
        else
            JOptionPane.showMessageDialog(null, "You have entered an INVALID account number. Please contact your administrator.");

        System.exit(0);
    }
}
