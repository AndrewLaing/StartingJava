/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
import java.text.DecimalFormat;

public class ShiftSupervisor extends Employee
{
    private double annualSalary;
    private double annualProductionBonus;

    public ShiftSupervisor()
    {
        super();
        annualSalary = 0.0;
        annualProductionBonus = 0.0;
    }


    public ShiftSupervisor(double annualSalary, double annualProductionBonus)
    {
        super();
        this.annualSalary = annualSalary;
        this.annualProductionBonus = annualProductionBonus;
    }


    public ShiftSupervisor(String name, String employeeNum, String hireDate,
                           double annualSalary, double annualProductionBonus)
    {
        super(name, employeeNum, hireDate);
        this.annualSalary = annualSalary;
        this.annualProductionBonus = annualProductionBonus;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualProductionBonus(double annualProductionBonus) {
        this.annualProductionBonus = annualProductionBonus;
    }

    public double getAnnualProductionBonus() {
        return annualProductionBonus;
    }

    public String toString()
    {
        DecimalFormat pounds = new DecimalFormat("£#0.00");

        return "Employee" +
                "\nName: " + getName() +
                "\nEmployee Number: " + getEmployeeNum() +
                "\nHire Date: " + getHireDate() +
                "\n\nShift Supervisor" +
                "\nAnnual Salary: " + pounds.format(getAnnualSalary()) +
                "\nAnnnual Production Bonus: " + pounds.format(getAnnualProductionBonus());
    }
}
