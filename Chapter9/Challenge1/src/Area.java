/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/11/2016.
 */
public class Area
{
    // Overloaded method for Circle area
    public static double area(double radius)
    {
        return Math.PI * (radius * radius);
    }


    // Overloaded method for rectangle area
    public static double area(int width, int length )
    {
        return width * length;
    }


    // Overloaded method for cylinder area
    public static double area(double radius, int height)
    {
        return Math.PI * (radius * radius) * height;
    }

}
