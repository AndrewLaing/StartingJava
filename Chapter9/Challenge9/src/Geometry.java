/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   26/11/2016.
 */
public class Geometry
{
    public static final double PI = 3.14159;

    public static double areaOfCircle(double radius)
    {
        return PI * (radius * radius);
    }

    public static double areaOfRectangle(double length, double width)
    {
        return length * width;
    }


    public static double areaOfTriangle(double base, double height)
    {
        return base * height * 0.5;
    }
}
