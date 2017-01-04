/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/09/2016.
 */

import javax.swing.JOptionPane;     // needed for input/output dialogues
import java.text.DecimalFormat;     // needed for DecimalFormat class

public class Challenge7
{
    public static void main(String[] args)
    {
        // Used to format the calculated average score
        DecimalFormat avScore = new DecimalFormat("#0.00");

        // Used to hold the test scores
        int[] scores = new int[5];

        // Used to temporarily store the user's input
        String input;
        int temp;

        // The results string
        String results = "Your grades on the tests were;\n\n";

        // Used to hold the average score
        float average;

        // Get the user to input five scores, calculate the grades for them,
        // and add the results to the result string
        for(int i=0; i<5; i++)
        {
            input = JOptionPane.showInputDialog("Enter your grade for Test " + (i+1));
            temp = Integer.parseInt(input);
            scores[i] = temp;
            results += "Test " + i + ": " + determineGrade(temp) + "\n";
        }

        // Calculate the average score and add it to the result string
        average = calcAverage(scores[0], scores[1], scores[2], scores[3], scores[4]);
        results += "\nAnd your average score was;\n\n" + avScore.format(average) + "\n\n";

        // Show the result string to the user
        JOptionPane.showMessageDialog(null, results);
    }


    /**
     * The method calcAverage calculates and returns an average score from
     * the five scores passed to it
     * @param score1 The score for test 1
     * @param score2 The score for test 2
     * @param score3 The score for test 3
     * @param score4 The score for test 4
     * @param score5 The score for test 5
     * @return The average score of the five tests as a float
     */
    public static float calcAverage(int score1, int score2, int score3,
                                    int score4, int score5)
    {
        float average;
        average = (score1 + score2 + score3 + score4 + score5)/5.0F;
        return average;
    }


    /**
     * The method determineGrade calculates and returns a grade for
     * the score passed to it
     * @param score A test score to return the grade for
     * @return A character representing the calculated grade
     */
    public static char determineGrade(int score)
    {
        if(score>=90)
            return 'A';
        else if(score>=80)
            return 'B';
        else if(score>=70)
            return 'C';
        else if (score>=60)
            return 'D';
        else
            return 'F';
    }
}
