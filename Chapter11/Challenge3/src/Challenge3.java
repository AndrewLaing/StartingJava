/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
public class Challenge3
{
    public static void main(String[] args)
    {

        ProductionWorker worker1 = new ProductionWorker("John Doe", "454-L", "12/01/2017", 2, 15.50);
        ProductionWorker worker2 = new ProductionWorker("Jane Doe", "463-B", "23/09/2015", 1, 12.50);

        TeamLeader worker3 = new TeamLeader(worker2, 2.50, 50, 25);

        System.out.println(worker1);
        System.out.println();
        System.out.println(worker2);
        System.out.println();
        System.out.println("---- Worker 2 has been promoted ----");
        System.out.println(worker3);
    }
}
