/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */

import java.text.DecimalFormat;

public class TeamLeader extends ProductionWorker
{
    private double monthlyBonus;
    private int requiredTrainingHours;
    private int attendedTrainingHours;

    public TeamLeader()
    {
        super();
        monthlyBonus = 0.0;
        requiredTrainingHours = 0;
        attendedTrainingHours = 0;
    }


    public TeamLeader(double monthlyBonus, int requiredTrainingHours, int attendedTrainingHours)
    {
        super();
        this.monthlyBonus = monthlyBonus;
        this.requiredTrainingHours = requiredTrainingHours;
        this.attendedTrainingHours = attendedTrainingHours;
    }


    public TeamLeader(String name, String employeeNum, String hireDate,
                      int shift, double hourlyPayRate,
                      double monthlyBonus, int requiredTrainingHours, int attendedTrainingHours)
    {
        super(name, employeeNum, hireDate, shift, hourlyPayRate);
        this.monthlyBonus = monthlyBonus;
        this.requiredTrainingHours = requiredTrainingHours;
        this.attendedTrainingHours = attendedTrainingHours;
    }

    public TeamLeader(ProductionWorker worker,
                      double monthlyBonus, int requiredTrainingHours, int attendedTrainingHours)
    {
        super(worker);
        this.monthlyBonus = monthlyBonus;
        this.requiredTrainingHours = requiredTrainingHours;
        this.attendedTrainingHours = attendedTrainingHours;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setRequiredTrainingHours(int requiredTrainingHours) {
        this.requiredTrainingHours = requiredTrainingHours;
    }

    public int getRequiredTrainingHours() {
        return requiredTrainingHours;
    }

    public void setAttendedTrainingHours(int attendedTrainingHours) {
        this.attendedTrainingHours = attendedTrainingHours;
    }

    public int getAttendedTrainingHours() {
        return attendedTrainingHours;
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
                "\nHourly Pay Rate: " + pounds.format(getHourlyPayRate()) +

                "\n\nTeam Leader" +
                "\nMonthly Bonus: " + pounds.format(getMonthlyBonus()) +
                "\nRequired Training Hours: " + getRequiredTrainingHours() +
                "\nAttended Training Hours: " + getAttendedTrainingHours();
    }
}
