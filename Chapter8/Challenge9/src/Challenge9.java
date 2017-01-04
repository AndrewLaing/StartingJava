/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   17/11/2016.
 */

import javax.swing.*;
import java.util.Random;


public class Challenge9
{

    private static final int MAX = 9;                    // Random number chosen cannot be > this
    private static final int ARRAY_LENGTH = 5;
    private static Random RandomNumbers = new Random();  // object for creating Random numbers

    private static int[] RandomLotteryNumbers = new int[ARRAY_LENGTH];
    private static int[] PlayerLotteryNumbers = new int[ARRAY_LENGTH];

    /**
     * The method getRandomNumber returns a random number between
     * 1 and max
     * @param max The highest number to return
     * @return a random number between 1 and max
     */
    public static int getRandomNumber(int max)
    {
        int rnd = RandomNumbers.nextInt(max);
        rnd++;
        return rnd;
    }

    /**
     * The method getRandomLotteryNumbers returns a copy of the
     * RandomLotteryNumbers array
     * @return Copy of the RandomLotteryNumbers array
     */
    private static int[] getRandomLotteryNumbers()
    {
        int[] copy = new int[ARRAY_LENGTH];

        for(int i=0; i<ARRAY_LENGTH; i++)
        {
            copy[i] = RandomLotteryNumbers[i];
        }

        return copy;
    }

    /**
     * The method getPlayerLotteryNumbers returns a copy of the
     * PlayerLotteryNumbers array
     * @return Copy of the PlayerLotteryNumbers array
     */
    private static int[] getPlayerLotteryNumbers()
    {
        int[] copy = new int[ARRAY_LENGTH];

        for(int i=0; i<ARRAY_LENGTH; i++)
        {
            copy[i] = PlayerLotteryNumbers[i];
        }

        return copy;
    }

    public static boolean numberInRandomLotteryNumbers(int n)
    {
        for(int i=0; i<ARRAY_LENGTH; i++)
        {
            if(RandomLotteryNumbers[i]==n)
                return true;
        }
        return false;
    }

    public static boolean numberInPlayerLotteryNumbers(int n)
    {
        for(int i=0; i<ARRAY_LENGTH; i++)
        {
            if(PlayerLotteryNumbers[i]==n)
                return true;
        }
        return false;
    }

    /**
     * The method correctNumbers returns the number of correct numbers
     * that the player has chosen from the winning ones
     * @return The number of correct numbers that the player has chosen from the winning ones
     */
    public static int correctNumbers()
    {
        int correct = 0;

        for(int i : PlayerLotteryNumbers)
        {
            for(int win : RandomLotteryNumbers)
            {
                if(i==win)
                    correct++;
            }
        }

        return correct;
    }

    public static void chooseRandomLotteryNumbers()
    {
        boolean isUnique = false;
        int num;

        // Add unique numbers to the RandomLotteryNumbers array
        for(int i=0; i<ARRAY_LENGTH; i++)
        {
            isUnique = false;
            while(!isUnique){
                num = getRandomNumber(MAX);
                if (!numberInRandomLotteryNumbers(num))
                {
                    isUnique = true;
                }
                RandomLotteryNumbers[i] = num;
            }
        }
    }

    public static void choosePlayerLotteryNumbers()
    {
        boolean isUnique = false;
        String input;   // to hold the Players input
        int num;

        // Add unique numbers to the RandomLotteryNumbers array
        for(int i=0; i<ARRAY_LENGTH; i++)
        {
            isUnique = false;
            input = JOptionPane.showInputDialog("Enter choice #" + (i+1));
            while(!isUnique)
            {
                try {
                    num = Integer.parseInt(input);
                    if (!numberInPlayerLotteryNumbers(num))
                    {
                        if(num>0 && num <=MAX)
                        {
                            PlayerLotteryNumbers[i] = num;
                            isUnique = true;
                        }
                        else {
                            input = JOptionPane.showInputDialog("Sorry - number must be between 1 and" +
                                                                 MAX + ". Please enter another number:");
                        }
                    }
                    else {
                        input = JOptionPane.showInputDialog("Sorry - you have already used that number." +
                                                            " Please enter another number:");
                    }
                }
                catch (Exception e){
                    input = JOptionPane.showInputDialog("Error - Invalid Input. Please enter a valid number:");
                }
            }
        }
    }

    public static void displayResults()
    {
        String result = "\tRESULTS\n\n";
        int correctNumbers = 0;

        result += "Winning Lottery Numbers\t";
        for(int i=0; i < ARRAY_LENGTH; i++)
        {
            result += RandomLotteryNumbers[i] + " ";
        }
        result += "\n";

        result += "Players Lottery Numbers\t";
        for(int i=0; i < ARRAY_LENGTH; i++)
        {
            result += PlayerLotteryNumbers[i] + " ";
        }
        result += "\n";

        result += "Correct numbers\t";
        for(int i=0; i < ARRAY_LENGTH; i++)
        {
            if(PlayerLotteryNumbers[i] == RandomLotteryNumbers[i])
            {
                result += "X ";
                correctNumbers++;
            }
            else            {
                result += "0 ";
            }
        }
        result += "\n";

        result += "\nTOTAL CORRECT NUMBERS = " + correctNumbers + "\n";

        if(correctNumbers==ARRAY_LENGTH)
            result += "\nCONGRATULATIONS!!! YOU HAVE WON THE GRAND PRIZE!!!\n";

        JOptionPane.showMessageDialog(null, new JTextArea(result));
        System.exit(0);
    }

    public static void main(String[] args)
    {
        choosePlayerLotteryNumbers();
        chooseRandomLotteryNumbers();
        displayResults();
        System.exit(0);
    }
}
