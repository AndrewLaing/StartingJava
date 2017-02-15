/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */
public class Employee
{
    private int IDNumber;
    private String name;

    public Employee(int IDNumber, String name)
    {
        this.IDNumber = IDNumber;
        this.name = name;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // Create a String representing the object
        String str = "ID Number: " + IDNumber +
                "\nName: " + name;

        return str;
    }
}
