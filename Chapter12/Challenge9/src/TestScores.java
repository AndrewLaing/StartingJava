import java.io.Serializable;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */

import java.io.*;

public class TestScores implements Serializable
{
    private int testScores[];

    public TestScores(int[] testScores)
    {
        int len = testScores.length;
        this.testScores = new int[len];


        int temp = 0;
        for(int i=0; i<len; i++)
        {
            temp = testScores[i];
            if(temp<0 || temp>100)
                throw new IllegalArgumentException();
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

