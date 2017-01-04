/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */

public class Challenge5
{
    public static void main(String[] args)
    {
        System.out.println("\nEmployee #1");
        try {
            Payroll emp1 = new Payroll("Carl Perkins", 123415);
            emp1.setHoursWorked(20);
            emp1.setHourlyPayRate(22);
            System.out.println(emp1);
        }
        catch (EmptyNameException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidIdNumberException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidPayRateException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidHoursWorkedException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\nEmployee #2");
        try {
            Payroll emp2 = new Payroll("", 123415);
            emp2.setHoursWorked(20);
            emp2.setHourlyPayRate(39);
            System.out.println(emp2);
        }
        catch (EmptyNameException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidIdNumberException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidPayRateException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidHoursWorkedException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\nEmployee #3");
        try {
            Payroll emp3 = new Payroll("Carl Perkins", -15);
            emp3.setHoursWorked(20);
            emp3.setHourlyPayRate(39);
            System.out.println(emp3);
        }
        catch (EmptyNameException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidIdNumberException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidPayRateException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidHoursWorkedException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\nEmployee #4");
        try {
            Payroll emp4 = new Payroll("Carl Perkins", 123415);
            emp4.setHoursWorked(200);
            emp4.setHourlyPayRate(39);
            System.out.println(emp4);
        }
        catch (EmptyNameException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidIdNumberException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidPayRateException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidHoursWorkedException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("\nEmployee #5");
        try {
            Payroll emp5 = new Payroll("Carl Perkins", 123415);
            emp5.setHoursWorked(20);
            emp5.setHourlyPayRate(39);
            System.out.println(emp5);
        }
        catch (EmptyNameException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidIdNumberException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidPayRateException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidHoursWorkedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
