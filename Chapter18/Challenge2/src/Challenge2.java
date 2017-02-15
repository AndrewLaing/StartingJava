/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/01/2017.
 */

import java.util.Scanner;

public class Challenge2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String input;

        Instructor i1 =
                new Instructor("Kramer", "Shawn", "RH3010");
        Instructor i2 =
                new Instructor("Davis", "Elizabeth", "RH3020");
        Instructor i3 =
                new Instructor("Bogart", "Humphrey", "RH3310");
        Instructor i4 =
                new Instructor("Davis", "Steve", "RH3010");
        Instructor i5 =
                new Instructor("Cranshaw", "Owen", "RH3030");
        Instructor i6 =
                new Instructor("Duckworth", "Aaron", "RH3010");

        InstructorHashSet iSet = new InstructorHashSet();
        iSet.add(i1);
        iSet.add(i2);
        iSet.add(i3);
        iSet.add(i4);
        iSet.add(i5);
        iSet.add(i6);

        // Display all of the Instructors added
        iSet.displayAllInstructors();

        // Get the lastname of an Instructor to search for
        System.out.println("Enter the last name of the instructor\nto search for: ");
        input = keyboard.nextLine();

        // search for the Instructor
        iSet.search(input);

    }
}
