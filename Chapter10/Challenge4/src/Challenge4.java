/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/12/2016.
 */

import javax.swing.JOptionPane;

public class Challenge4
{

    private static final String menu =
            "Vowels and Consonants Application.\n" +
            "\na. Count the number of vowels in the string." +
            "\nb. Count the number of consonants in the string." +
            "\nc. Count both vowels and consonants in the string." +
            "\nd. Enter another string." +
            "\ne. Exit the program." +
            "\n\nEnter your choice:";

    private static final char[] validMenuOptions  = {'a','b','c','d','e'};
    private static final char invalidMenuOption = 'X';


    public static char getUserOption()
    {
        String input = "";
        // It is not necessary to initialise choice this way but it makes it easier to update
        //    the menu without accidentally setting an option to the escape character
        char choice = invalidMenuOption;

        // Get a valid choice from the user
        boolean validInput = false;
        while(!validInput)
        {
            try {
                input = JOptionPane.showInputDialog(menu);
                choice = Character.toLowerCase( input.charAt(0) );

                // Check that the user has made a valid choice
                for(char c : validMenuOptions)
                {
                    if(c==choice)
                        validInput = true;
                }

                if(!validInput)
                    JOptionPane.showMessageDialog(null, "Invalid choice!");

            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }

        }

        return choice;
    }

    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Enter a string");

        VowelAndConsonants vc = new VowelAndConsonants(input);

        boolean keepAsking = true;
        char choice = invalidMenuOption;

        while(keepAsking)
        {
            choice = getUserOption();

            switch (choice)
            {
                case 'a':
                    JOptionPane.showMessageDialog(null,
                                                 "There are " + vc.countVowels() +
                                                 " vowels in the string.");
                    break;
                case 'b':
                    JOptionPane.showMessageDialog(null,
                                                "There are " + vc.countConsonants() +
                                                " consonants in the string.");
                    break;
                case 'c':
                    JOptionPane.showMessageDialog(null,
                                                "There are " + vc.countVowelsAndConsonants() +
                                                " combined vowels and consonants in the string.");
                    break;
                case 'd':
                    String newString = JOptionPane.showInputDialog("Enter the new string");
                    vc.setSentence(newString);
                    JOptionPane.showMessageDialog(null, "The string has been changed..");
                    break;
                default:
                    keepAsking = false;
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Exiting Application.");
        System.exit(0);
    }
}
