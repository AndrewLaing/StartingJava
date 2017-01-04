/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class CourseGrades
{
    public GradedActivity[] grades = new GradedActivity[4];

    public void setLab(GradedActivity lab)
    {
        grades[0] = new GradedActivity(lab);
    }

    public void setPassFailExam(PassFailExam pfExam)
    {
        grades[1] = new PassFailExam(pfExam);
    }

    public void setEssay(Essay essay)
    {
        grades[2] = new Essay(essay);
    }

    public void setFinalExam(FinalExam finalExam)
    {
        grades[3] = new FinalExam(finalExam);
    }

    public String toString()
    {
        return "---- COURSE GRADES ----" +
                "\nLab Activity" +
                "\nScore: " + grades[0].getScore() +
                "\nGrade: " + grades[0].getGrade() +
                "\n\nPass/Fail Exam" +
                "\nScore: " + grades[1].getScore() +
                "\nGrade: " + grades[1].getGrade() +
                "\n\nEssay" +
                "\nScore: " + grades[2].getScore() +
                "\nGrade: " + grades[2].getGrade() +
                "\n\nFinal Exam" +
                "\nScore: " + grades[3].getScore() +
                "\nGrade: " + grades[3].getGrade();
    }
}
