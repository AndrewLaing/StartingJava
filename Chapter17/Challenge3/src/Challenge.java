/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/01/2017.
 */
public class Challenge
{
    public static void main(String[] args) {


        // create a PointList object
        PointList myPointList = new PointList();

        // create Integer objects as coordinates
        Integer intx = new Integer(10);
        Integer inty = new Integer(20);
        Integer intx1 = new Integer(12);
        Integer inty1 = new Integer(22);
        Integer intx2 = new Integer(33);
        Integer inty2 = new Integer(32);
        Integer intx3 = new Integer(42);
        Integer inty3 = new Integer(44);

        // create point objects
        Point<Integer> i= new Point<Integer>(intx, inty);
        Point<Integer> i1= new Point<Integer>(intx1, inty1);
        Point<Integer> i2= new Point<Integer>(intx2, inty2);
        Point<Integer> i3= new Point<Integer>(intx3, inty3);

        // add the points to the PointList objects ArrayList
        myPointList.add(i);
        myPointList.add(i1);
        myPointList.add(i2);
        myPointList.add(i3);

        // Display the coordinates of the stored points
        myPointList.printPoints();
    }
}
