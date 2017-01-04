/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */

import java.util.Scanner;


public class Challenge4
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Essay essay1 = new Essay();

        System.out.print("Enter the Grammar score (0-30)");
        essay1.setGrammar(keyboard.nextInt());

        System.out.print("Enter the Spelling score (0-20)");
        essay1.setSpelling(keyboard.nextInt());

        System.out.print("Enter the Correct Length score (0-20)");
        essay1.setCorrectLength(keyboard.nextInt());

        System.out.print("Enter the Content score (0-30)");
        essay1.setContent(keyboard.nextInt());

        System.out.println("This essay was graded " + essay1.getGrade());
    }
}
