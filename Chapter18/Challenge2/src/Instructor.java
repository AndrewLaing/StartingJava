/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   20/11/2016.
 */
public class Instructor
{
    private String lastName;
    private String firstName;
    private String officeNumber;

    /**
     * Constructor
     * @param lname The instructor's last name
     * @param fname The instructor's first name
     * @param office The office number
     */
    public Instructor(String lname, String fname, String office)
    {
        lastName = lname;
        firstName = fname;
        officeNumber = office;
    }

    /**
     * Copy constructor
     * @param object2 The object to copy
     */
    public Instructor(Instructor object2)
    {
        lastName = object2.lastName;
        firstName = object2.firstName;
        officeNumber = object2.officeNumber;
    }

    /**
     * The method set() sets a value for each field
     * @param lname The instructor's last name
     * @param fname The instructor's first name
     * @param office The office number
     */
    public void set(String lname, String fname, String office)
    {
        lastName = lname;
        firstName = fname;
        officeNumber = office;
    }

    @Override
    public int hashCode() {
        return lastName.hashCode();
    }

    public boolean equals(Instructor obj) {
        return lastName.equals(obj.lastName);
    }

    // Only the lastname is needed by an outside class at the moment
    public String getLastName() {
        return lastName;
    }

    public String toString()
    {
        // Create a String representing the object
        String str = "Last Name: " + lastName +
                     "\nFirst Name: " + firstName +
                     "\nOffice Number: " + officeNumber;

        return str;
    }
}
