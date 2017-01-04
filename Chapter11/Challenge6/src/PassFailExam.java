/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class PassFailExam extends PassFailActivity
{
    private int numQuestions;       // number of questions
    private double pointsEach;      // points for each question
    private int numMissed;          // questions missed

    public PassFailExam()
    {
        super(0);
        this.numQuestions = 0;
        this.numMissed = 0;
        this.pointsEach = 0;
    }

    public PassFailExam(int numQuestions, int numMissed, double minPassing)
    {
        // Call the superclass constructor
        super(minPassing);

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


    /**
     * Copy Constructor
     * @param object2 Object to be copied
     */
    public PassFailExam(PassFailExam object2)
    {
        super(object2.getMinPassingScore());

        double numericScore;
        this.numQuestions = object2.getNumQuestions();
        this.numMissed = object2.getNumMissed();
        this.pointsEach = object2.getPointsEach();

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

