/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   30/09/2016.
 */
public class Challenge1
{
    public static void main(String[] args)
    {
        Employee employee1 = new Employee("Susan Meyers", 47899, "Accounting",    "Vice President");
        Employee employee2 = new Employee("Mark Jones",   39119, "IT",            "Programmer");
        Employee employee3 = new Employee("Joy Rogers",   81774, "Manufacturing", "Engineer");


        System.out.printf("Name\t\t\tID Number\tDepartment\t\tPosition\n");
        System.out.printf("%s\t%d\t\t%s\t\t%s\n", employee1.getName(), employee1.getIdNumber(),
                                                  employee1.getDepartment(), employee1.getPosition());
        System.out.printf("%s\t\t%d\t\t%s\t\t\t\t%s\n", employee2.getName(), employee2.getIdNumber(),
                                                  employee2.getDepartment(), employee2.getPosition());
        System.out.printf("%s\t\t%d\t\t%s\t%s\n", employee3.getName(), employee3.getIdNumber(),
                                                  employee3.getDepartment(), employee3.getPosition());

    }
}
