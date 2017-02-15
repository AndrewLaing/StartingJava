/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/01/2017.
 */

import java.util.*;

public class InstructorHashSet
{
    private Set<Instructor> instructors;

    public InstructorHashSet()
    {
        instructors = new HashSet<Instructor>();
    }

    public void add(Instructor instructor)
    {
        instructors.add(instructor);
    }

    public void displayAllInstructors()
    {
        for(Instructor i : instructors) {
            System.out.println(i);
            System.out.println();
        }
    }

    // do a sequential search for Instructors with the lastname
    public void search(String lastname)
    {
        boolean found = false;

        for(Instructor i : instructors)
        {
            if(i.getLastName().equalsIgnoreCase(lastname)) {
                found = true;
                System.out.println(i);
                System.out.println();
            }
        }

        if(!found)
            System.out.println("Instructor not found.");
    }
}
