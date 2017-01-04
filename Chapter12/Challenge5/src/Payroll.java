/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */

import java.text.DecimalFormat;

public class Payroll
{
    private final int MAX_WORKING_HOURS = 84;
    private final int MAX_HOURLY_PAYRATE = 25;

    private String name;
    private int idNumber;
    private double hourlyPayRate;
    private double hoursWorked;

    public Payroll(String name, int idNumber) throws EmptyNameException,
                                                     InvalidIdNumberException
    {
        if(!isValidName(name))
            throw new EmptyNameException();

        if(!isValidIdNumber(idNumber))
            throw new InvalidIdNumberException();

        this.name = name;
        this.idNumber = idNumber;
    }


    private boolean isValidName(String name)
    {
        return (name.length()>0);
    }

    private boolean isValidIdNumber(int idNumber)
    {
        return (idNumber>0);
    }

    private boolean isValidHoursWorked(double hoursWorked)
    {
        return (hoursWorked>=0 && hoursWorked<=MAX_WORKING_HOURS);
    }

    private boolean isValidPayRate(double hourlyPayRate)
    {
        return (hourlyPayRate>=0 && hourlyPayRate<=MAX_HOURLY_PAYRATE);
    }

    public void setName(String name) throws EmptyNameException
    {
        if(!isValidName(name))
            throw new EmptyNameException();

        this.name = name;
    }

    public void setIdNumber(int idNumber) throws InvalidIdNumberException
    {
        if(!isValidIdNumber(idNumber))
            throw new InvalidIdNumberException();

        this.idNumber = idNumber;
    }

    public void setHourlyPayRate(double hourlyPayRate) throws InvalidPayRateException
    {
        if(!isValidPayRate(hourlyPayRate))
            throw new InvalidPayRateException();

        this.hourlyPayRate = hourlyPayRate;
    }

    public void setHoursWorked(double hoursWorked) throws InvalidHoursWorkedException
    {
        if(!isValidHoursWorked(hoursWorked))
            throw new InvalidHoursWorkedException();

        this.hoursWorked = hoursWorked;
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


    public String toString()
    {
        DecimalFormat pounds = new DecimalFormat("£#0.00");
        DecimalFormat hours = new DecimalFormat("#0.00");
        return "Name: " + getName() +
                "\nID Number: " + getIdNumber() +
                "\nHours Worked: " + hours.format(getHoursWorked()) +
                "\nHourly Pay Rate: " + pounds.format(getHourlyPayRate());
    }
}

