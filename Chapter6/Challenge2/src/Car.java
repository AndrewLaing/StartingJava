/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/10/2016.
 */
public class Car
{
    private int yearModel;
    private String make;
    private int speed;


    /**
     * Constructor
     * @param ym The year of the model of car
     * @param m The make of car
     */
    public Car(int ym, String m)
    {
        yearModel = ym;
        make = m;
        speed = 0;
    }


    /**
     * The method getYearModel returns the value in the yearModel field
     * @return The value in the yearModel field
     */
    public int getYearModel()
    {
        return yearModel;
    }


    /**
     * The method getMake returns the value in the make field
     * @return The value in the make field
     */
    public String getMake()
    {
        return make;
    }


    /**
     * The method getSpeed returns the value in the speed field
     * @return The value in the speed field
     */
    public int getSpeed()
    {
        return speed;
    }


    /**
     * The method acccelerate adds 5 to the speed
     */
    public void accelerate()
    {
        speed += 5;
    }


    /**
     * The method brake subtracts 5 from the speed
     */
    public void brake()
    {
        // Speed cannot be less than zero
        if(speed > 0)
            speed -= 5;

        if(speed < 0)
            speed = 0;

    }
}
