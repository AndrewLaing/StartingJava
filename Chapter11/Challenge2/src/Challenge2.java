/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
public class Challenge2
{
    public static void main(String[] args)
    {
        ProductionWorker worker1 = new ProductionWorker("John Doe", "454-L", "12/01/2017", 2, 15.50);
        ShiftSupervisor worker2 = new ShiftSupervisor("Jane Doe", "463-B", "23/09/2015", 45000.00, 5000.00);

        System.out.println(worker1);
        System.out.println();
        System.out.println(worker2);
    }
}
