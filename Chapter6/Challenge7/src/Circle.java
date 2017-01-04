/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */
public class Circle
{
    private double radius;
    private final double PI = 3.14159;

    public Circle()
    {
        radius = 0.0;
    }

    public Circle(double r)
    {
        radius = r;
    }

    public void setRadius(double r)
    {
        radius = r;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getArea()
    {
        return PI * radius * radius;
    }

    public double getDiameter()
    {
        return radius *2;
    }

    public double getCircumference()
    {
        return 2 * PI * radius;
    }
}
