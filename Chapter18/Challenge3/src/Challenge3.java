/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */

import java.util.Scanner;

public class Challenge3
{
    public static void main(String[] args)
    {
        // create a Scanner object
        Scanner keyboard = new Scanner(System.in);
        String input;

        // create some Employee objects
        Employee e1 = new Employee(1012, "Sarah Connor");
        Employee e2 = new Employee(1013, "John Connor");
        Employee e3 = new Employee(1014, "Lauren Bacall");
        Employee e4 = new Employee(1015, "Jean Paul Belmondo");
        Employee e5 = new Employee(1016, "Brigitte Bardot");
        Employee e6 = new Employee(1017, "Nancy Sinatra");
        Employee e7 = new Employee(1018, "Maurice Micklewhite");

        // create a new employeemap
        EmployeeMap eMap = new EmployeeMap();

        // add the Employees to the EmployeeMap
        eMap.add(e1.getIDNumber(),e1);
        eMap.add(e2.getIDNumber(),e2);
        eMap.add(e3.getIDNumber(),e3);
        eMap.add(e4.getIDNumber(),e4);
        eMap.add(e5.getIDNumber(),e5);
        eMap.add(e6.getIDNumber(),e6);
        eMap.add(e7.getIDNumber(),e7);

        // Ask the user for an Employee Number to search for
        System.out.println("Enter the number of the employee to search for: ");
        input = keyboard.nextLine();

        Employee result = eMap.search(Integer.parseInt(input));

        if(result!=null)
            System.out.println(result);
        else
            System.out.println("Employee " + input + " not found");
    }
}
