/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */
public class Payroll
{
    private String name;
    private int idNumber;
    private double hourlyPayRate;
    private double hoursWorked;

    public Payroll()
    {

    }

    public Payroll(String n, int id)
    {
        name = n;
        idNumber = id;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setIdNumber(int id)
    {
        idNumber = id;
    }

    public void setHourlyPayRate(double hpr)
    {
        hourlyPayRate = hpr;
    }

    public void setHoursWorked(double hw)
    {
        hoursWorked = hw;
    }

    public String getName()
    {
        return name;
    }

    public int getIdNumber()
    {
        return idNumber;
    }

    public double getHourlyPayRate()
    {
        return hourlyPayRate;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public double calculateGrossPay()
    {
        return hoursWorked * hoursWorked;
    }
}
