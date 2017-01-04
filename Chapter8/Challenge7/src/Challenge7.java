/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   16/11/2016.
 */

import javax.swing.*;
import java.text.DecimalFormat;

public class Challenge7
{
    private static final int numberOfStudents = 6;
    private static final int numberOfTests = 4;

    private static String[] StudentNames = new String[numberOfStudents];
    private static char[] StudentGrades = new char[numberOfStudents];
    private static double[][] StudentScores = new double[numberOfStudents][numberOfTests];


    private static boolean isValidGrade(double grade)
    {
        if(grade>=0 && grade<=100)
            return true;
        return false;
    }

    private static void setStudentScores(int StudentNumber)
    {
        String input;   // to hold the user's input
        boolean isValidInput = false;
        double grade;

        for(int i=0; i<numberOfTests; i++)
        {
            isValidInput = false;
            input = JOptionPane.showInputDialog("Input test score #" + (i+1) + " for student #" + (StudentNumber+1));
            while(!isValidInput)
            {
                try
                {
                    grade = Double.parseDouble(input);
                    if(isValidGrade(grade))
                    {
                        StudentScores[StudentNumber][i] = grade;
                        isValidInput = true;
                    }
                    else {
                        input = JOptionPane.showInputDialog("Error number out of range - Please enter a valid score for test #" + (i+1));
                    }
                }
                catch (Exception e)
                {
                    input = JOptionPane.showInputDialog("Error invalid input - Please enter a valid score for test #" + (i+1));
                }
            }
        }
    }

    private static void setStudentGrade(int StudentNumber)
    {
        double averageScore  = getStudentAverageScore(StudentNumber);
        StudentGrades[StudentNumber]=getStudentGrade(averageScore);
    }

    private static char getStudentGrade(double averageScore)
    {
        if(averageScore>=90)
            return 'A';
        else if(averageScore>=80)
            return 'B';
        else if(averageScore>=70)
            return 'C';
        else if(averageScore>=60)
            return 'D';
        else
            return 'F';
    }

    private static double getStudentAverageScore(int StudentNumber)
    {
        double average = 0;
        for(int i=0; i<numberOfTests; i++)
            average += StudentScores[StudentNumber][i];

        return average/numberOfTests;
    }

    private static void setStudentName(int StudentNumber)
    {
        String input = JOptionPane.showInputDialog("Input name of student #" + (StudentNumber+1));
        StudentNames[StudentNumber] = input;
    }

    private static String getStudentName(int StudentNumber)
    {
        return StudentNames[StudentNumber];
    }


    private static String getStudentResultString(int StudentNumber)
    {
        DecimalFormat grade = new DecimalFormat("#0.00");

        String result = "" + getStudentName(StudentNumber) + "\t";
        result += grade.format(getStudentAverageScore(StudentNumber)) + "\t";
        result += StudentGrades[StudentNumber] + "\t\n";

        return result;
    }

    private static void displayResults()
    {
        String result = "RESULTS\n\nName\tAverage Score\tGrade\n";

        for(int StudentNumber=0; StudentNumber<numberOfStudents; StudentNumber++)
            result += getStudentResultString(StudentNumber);

        // Note using the testArea allows tabs and newlines to be displayed
        JOptionPane.showMessageDialog(null, new JTextArea(result));
    }

    public static void main(String[] args)
    {
        for(int StudentNumber=0; StudentNumber<numberOfStudents; StudentNumber++)
        {
            setStudentName(StudentNumber);
            setStudentScores(StudentNumber);
            setStudentGrade(StudentNumber);
        }

        displayResults();
    }
}
