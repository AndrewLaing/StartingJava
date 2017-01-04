/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class PassFailActivity extends GradedActivity
{
    private double minPassingScore;

    public PassFailActivity(double mps)
    {
        minPassingScore = mps;
    }

    public char getGrade()
    {
        char letterGrade;

        if(super.getScore() >= minPassingScore)
            letterGrade = 'P';
        else
            letterGrade = 'F';

        return letterGrade;
    }

    public double getMinPassingScore() {
        return minPassingScore;
    }
}