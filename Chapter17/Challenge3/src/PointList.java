/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/01/2017.
 */

import java.util.ArrayList;

public class PointList <T extends Point<T>>
{

    ArrayList<Point<T>> points;

    public PointList()
    {
        points = new ArrayList<Point<T>>();
    }

    public void add(Point<T> point)
    {
        points.add(point);
    }

    public void printPoints()
    {
        for(int i=0; i< points.size(); i++)
        {
            System.out.println("Here are the values in point " + (i+1));
            System.out.println("X Coordinate = " + points.get(i).getX());
            System.out.println("Y Coordinate = " + points.get(i).getY());
            System.out.println();
        }
    }


}
