/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
public class Employee
{
    private String name;
    private String employeeNum;
    private String hireDate;

    public Employee()
    {
        name = "";
        employeeNum = "";
        hireDate = "";
    }


    public Employee(String name, String employeeNum, String hireDate)
    {
        this.name = name;
        this.employeeNum = employeeNum;
        this.hireDate = hireDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getHireDate() {
        return hireDate;
    }
}

