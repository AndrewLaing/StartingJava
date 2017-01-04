/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
public class GradedActivity
{
    private double score;   // numeric score

    public void setScore(double score) {
        this.score = score;
    }


    public double getScore() {
        return score;
    }


    public char getGrade()
    {
        char letterGrade;

        if(score >= 90)
            letterGrade = 'A';
        else if(score >= 80)
            letterGrade = 'B';
        else if(score >= 70)
            letterGrade = 'C';
        else if(score >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';

        return letterGrade;
    }
}
