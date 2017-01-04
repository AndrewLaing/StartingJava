/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/10/2016.
 */
public class FreezingBoiling
{
    private float temperature;

    public FreezingBoiling()
    {
        temperature = 0;
    }

    public FreezingBoiling(float t)
    {
        temperature = t;
    }

    public void setTemperature(float t)
    {
        temperature = t;
    }

    public float getTemperature()
    {
        return temperature;
    }

    public boolean isEthylFreezing()
    {
        return temperature <= -114;
    }

    public boolean isEthylBoiling()
    {
        return temperature >= 78.4f;
    }


    public boolean isOxygenFreezing()
    {
        return temperature <= -218.8f;
    }

    public boolean isOxygenBoiling()
    {
        return temperature >= -183;
    }


    public boolean isWaterFreezing()
    {
        return temperature <= 0;
    }

    public boolean isWaterBoiling()
    {
        return temperature >= 100;
    }

}
