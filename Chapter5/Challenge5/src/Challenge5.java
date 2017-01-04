/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/09/2016.
 */
public class Challenge5
{
    public static final double G = 9.8; // Used in calculating the distance fell

    public static void main(String[] args)
    {
        double distanceFell;

        System.out.println("Time passed     Distance Fell");
        System.out.println("-----------------------------");
        for (int timePassed=1; timePassed<=10; timePassed++)
        {
            distanceFell = fallingDistance(timePassed);
            System.out.printf("%d\t\t\t\t%.2f meters\n", timePassed, distanceFell);
        }
    }


    /**
     * The method fallingDistance calculates and returns the distance that an object has fell
     * during a specified period of time
     * @param timePassed The amount of time in seconds that the object
     *                   has been falling for.
     * @return The distance fell in the time provided
     */
    public static double fallingDistance(int timePassed)
    {
        double distance;

        distance = 0.5 * (G * (timePassed * timePassed));

        return distance;
    }
}
