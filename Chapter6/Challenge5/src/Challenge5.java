/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;


public class Challenge5
{
    public static void main(String[] args)
    {
        Payroll emp1 = new Payroll("Carl Perkins", 123415);
        DecimalFormat dollars = new DecimalFormat("#,##0.00");

        String input;       // To hold the user's input
        double temp;        // To temporarily hold the user's input converted to a double

        // get the hourly pay rate
        input = JOptionPane.showInputDialog("Please enter the hourly payrate of\nEmployee no " + emp1.getIdNumber() +
                                             "\n" + emp1.getName());
        temp = Double.parseDouble(input);
        emp1.setHourlyPayRate(temp);

        // get the hours worked
        input = JOptionPane.showInputDialog("Please enter the hours worked by\nEmployee no " + emp1.getIdNumber() +
                "\n" + emp1.getName());
        temp = Double.parseDouble(input);
        emp1.setHoursWorked(temp);

        // show the employees gross pay
        JOptionPane.showMessageDialog(null, "The gross pay of Employee no " + emp1.getIdNumber() +
                "\n" + emp1.getName() + " is:\n   $"  + dollars.format(emp1.calculateGrossPay()));

        // Close the thread opened by the message dialog
        System.exit(0);
    }
}
