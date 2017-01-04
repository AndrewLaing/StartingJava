/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class FinalExam extends GradedActivity
{
    private int numQuestions;       // number of questions
    private double pointsEach;      // points for each question
    private int numMissed;          // questions missed


    public FinalExam()
    {
        numQuestions = 0;
        pointsEach =0;
        numMissed = 0;
    }

    public FinalExam(int numQuestions, int numMissed)
    {
        double numericScore;

        this.numQuestions = numQuestions;
        this.numMissed = numMissed;

        // calculate the points for each question and
        // the numeric score for this exam
        pointsEach = 100.0 / this.numQuestions;
        numericScore = 100.0 - (this.numMissed * pointsEach);

        // call the inherited setScore method  to set the numeric score
        setScore(numericScore);
    }

    public FinalExam(FinalExam object2)
    {
        double numericScore;

        this.numQuestions = object2.getNumQuestions();
        this.pointsEach = object2.getPointsEach();
        this.numMissed = object2.getNumMissed();

        numericScore = 100.0 - (this.numMissed * pointsEach);

        // call the inherited setScore method  to set the numeric score
        setScore(numericScore);
    }

    public double getPointsEach() {
        return pointsEach;
    }

    public int getNumMissed() {
        return numMissed;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}

