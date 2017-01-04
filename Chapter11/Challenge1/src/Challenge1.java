/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
public class Challenge1
{
    public static void main(String[] args)
    {
        ProductionWorker worker1 = new ProductionWorker("John Doe", "454-L", "12/01/2017", 2, 15.50);
        ProductionWorker worker2 = new ProductionWorker("Jane Doe", "463-B", "23/09/2015", 1, 12.50);

        System.out.println(worker1);
        System.out.println();
        System.out.println(worker2);
    }
}
