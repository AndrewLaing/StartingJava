/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */


public class TestScores
{
    private int testScore1;
    private int testScore2;
    private int testScore3;

    public TestScores()
    {
        testScore1 = 0;
        testScore2 = 0;
        testScore3 = 0;
    }


    public TestScores(int test1, int test2, int test3)
    {
        testScore1 = test1;
        testScore2 = test2;
        testScore3 = test3;
    }


    public void setTestScore1(int test1)
    {
        testScore1 = test1;
    }


    public void setTestScore2(int test2)
    {
        testScore2 = test2;
    }


    public void setTestScore3(int test3)
    {
        testScore1 = test3;
    }


    public int getTestScore1()
    {
        return testScore1;
    }

    public int getTestScore2()
    {
        return testScore2;
    }

    public int getTestScore3()
    {
        return testScore3;
    }


    public double calculateAverage()
    {
        return (testScore1 + testScore2 + testScore3)/3.0;
    }
}
