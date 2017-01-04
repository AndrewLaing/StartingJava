/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class Challenge2
{
    public static void main(String[] args) throws InvalidTestScore
    {
        int[] goodArray =  {78,85,95,86,94,96,83,85,84,96,75,85};
        int[] badArray =  {78,85,95,866,94,96,83,85,84,96,75,85};

        TestScores goodTest = new TestScores(goodArray);
        System.out.println("The average of good array is " + goodTest.getAverage());

        TestScores badTest = new TestScores(badArray);
        System.out.println("The average of bad array is " + badTest.getAverage());
    }
}
