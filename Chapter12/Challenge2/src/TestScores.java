/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class TestScores
{
    private int testScores[];

    public TestScores(int[] testScores) throws InvalidTestScore
    {
        int len = testScores.length;
        this.testScores = new int[len];


        int temp = 0;
        for(int i=0; i<len; i++)
        {
            temp = testScores[i];
            if(temp<0 || temp>100)
                throw new InvalidTestScore(temp);
            this.testScores[i] = temp;
        }
    }

    public double getAverage()
    {
        int total = 0;

        for(int i=0; i<testScores.length; i++)
        {
            total += this.testScores[i];
        }

        return ((double) total) / testScores.length;
    }
}
