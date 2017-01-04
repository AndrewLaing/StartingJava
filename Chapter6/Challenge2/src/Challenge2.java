/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/10/2016.
 */
public class Challenge2
{
    public static void main(String[] args)
    {
        Car golf = new Car(2015, "Golf");

        for(int i=0; i<5; i++)
        {
            golf.accelerate();
            System.out.printf("The current speed of the %s is %d\n", golf.getMake(), golf.getSpeed());
        }

        for(int i=0; i<5; i++)
        {
            golf.brake();
            System.out.printf("The current speed of the %s is %d\n", golf.getMake(), golf.getSpeed());
        }
    }
}
