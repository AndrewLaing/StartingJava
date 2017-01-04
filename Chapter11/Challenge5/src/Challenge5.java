/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class Challenge5
{
    public static void main(String[] args)
    {
        // create a GradedActivity object
        GradedActivity lab = new GradedActivity(95);

        // Create a PassFailExam object
        PassFailExam pfExam = new PassFailExam(10, 1, 70);

        // Create an Essay object
        Essay essay = new Essay(29, 18, 19, 28);

        // create a FinalExam object
        FinalExam finalExam = new FinalExam(50, 2);


        // Create a CourseGrades object
        CourseGrades course1 = new CourseGrades();
        course1.setLab(lab);
        course1.setPassFailExam(pfExam);
        course1.setEssay(essay);
        course1.setFinalExam(finalExam);

        // Print out the scores and grades
        System.out.println(course1);
    }
}
