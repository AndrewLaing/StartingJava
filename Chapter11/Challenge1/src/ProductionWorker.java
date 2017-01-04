/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */

import java.text.DecimalFormat;

public class ProductionWorker extends Employee
{
    private int shift;              // 1 - day shift, 2 - night shift
    private double hourlyPayRate;

    /**
     * No-arg constructor
     */
    public ProductionWorker()
    {
        super();
        shift = 1;
        hourlyPayRate = 0.0;
    }

    /**
     * Constructor #2 A deefault production worker with no Employee Details added
     * @param shift The shift that the employee will work on
     * @param hourlyPayRate The worker's hourly pay rate
     */
    public ProductionWorker(int shift, double hourlyPayRate)
    {
        super();
        this.shift = shift;
        this.hourlyPayRate = hourlyPayRate;
    }


    /**
     * Constructor #3 A specific production worker
     * @param name The worker's name
     * @param employeeNum The worker's employee number
     * @param hireDate The Worker's hire date
     * @param shift The shift that the employee will work on
     * @param hourlyPayRate The worker's hourly pay rate
     */
    public ProductionWorker(String name, String employeeNum, String hireDate,
                            int shift, double hourlyPayRate)
    {
        super(name, employeeNum, hireDate);
        this.shift = shift;
        this.hourlyPayRate = hourlyPayRate;
    }


    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public String toString()
    {
        DecimalFormat pounds = new DecimalFormat("£#0.00");

        return "Employee" +
                "\nName: " + getName() +
                "\nEmployee Number: " + getEmployeeNum() +
                "\nHire Date: " + getHireDate() +
                "\n\nProduction Worker" +
                "\nShift: " + (getShift()==1 ? "Day Shift" : "Night Shift") +
                "\nHourly Pay Rate: " + pounds.format(getHourlyPayRate());
    }

}
