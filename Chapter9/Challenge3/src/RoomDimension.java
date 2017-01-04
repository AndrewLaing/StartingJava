/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */
public class RoomDimension
{
    private double length;
    private double width;


    RoomDimension(RoomDimension object2)
    {
        length = object2.length;
        width = object2.width;
    }


    RoomDimension(double l, double w)
    {
        length = l;
        width = w;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double l) {
        length = l;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double w) {
        width = w;
    }

    public double getArea()
    {
        return length * width;
    }

    public String toString()
    {
        return "Room Dimensions:" +
                "\n Length: " + length +
                "\n Width: " + width;
    }

    public boolean equals(RoomDimension object2)
    {
        if(length==object2.length) {
            if(width==object2.width)
                return true;
        }

        return false;
    }



}
