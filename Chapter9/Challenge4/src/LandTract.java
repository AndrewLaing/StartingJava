/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */
public class LandTract
{
    private double length;
    private double width;

    public LandTract(double l, double w)
    {
        length = l;
        width = w;
    }

    public LandTract(LandTract object2)
    {
        length = object2.length;
        width = object2.width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea()
    {
        return length * width;
    }

    public String toString()
    {
        return "Land Tract: " +
                "\n Length: " + length +
                "\n Width: " + width;
    }

    /**
     * The method equals returns true if the length by width dimensions of the object
     * passed are equal to either the length by width, or the width by length
     * dimensions of this object
     * @param object2 A Land Tract
     * @return True is equal else false
     */
    public boolean equals(LandTract object2)
    {
        if(length==object2.length && width==object2.width)
            return true;
        if(length==object2.width && width==object2.length)
            return true;

        return false;
    }
}
