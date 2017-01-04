/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/09/2016.
 */
public class Employee
{
    private String name;
    private int idNumber;
    private String department;
    private String position;


    /**
     * Default no-arg constructor
     */
    public Employee()
    {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }


    /**
     * Constructor
     * @param n The employee's name
     * @param id The employee's ID number
     * @param dep The department where the employee works
     * @param pos The employee's job title
     */
    public Employee(String n, int id, String dep, String pos)
    {
        name = n;
        idNumber = id;
        department = dep;
        position = pos;
    }


    /**
     * Constructor
     * @param n The employee's name
     * @param id The employee's ID number
     */
    public Employee(String n, int id)
    {
        name = n;
        idNumber = id;
    }


    /**
     * The method setName sets the value in the name field
     * @param n The employee's name
     */
    public void setName(String n)
    {
        name = n;
    }


    /**
     * The method setIdNumber sets the value in the idNumber field
     * @param id employee's ID number
     */
    public void setIdNumber(int id)
    {
        idNumber = id;
    }


    /**
     * The method setDepartment sets the value in the department field
     * @param dep The department where the employee works
     */
    public void setDepartment(String dep)
    {
        department = dep;
    }


    /**
     * The method setPosition sets the value in the position field
     * @param pos The employee's job title
     */
    public void setPosition(String pos)
    {
        position = pos;
    }


    /**
     * The method getName returns the value in the name field
     * @return The value in the name field
     */
    public String getName()
    {
        return name;
    }


    /**
     * The method getIdNumber returns the value in the idNumber field
     * @return The value in the idNumber field
     */
    public int getIdNumber()
    {
        return idNumber;
    }


    /**
     * The method getDepartment returns the value in the department field
     * @return The value in the department field
     */
    public String getDepartment()
    {
        return department;
    }


    /**
     * The method getPosition returns the value in the position field
     * @return The value in the position field
     */
    public String getPosition()
    {
        return position;
    }
}
