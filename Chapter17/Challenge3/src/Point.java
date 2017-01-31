/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/01/2017.
 */
public class Point<T>
{
    private T xCoordinate;
    private T yCoordinate;

    public Point(T x, T y)
    {
        xCoordinate = x;
        yCoordinate = y;
    }

    public void setX(T xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public T getX() {
        return xCoordinate;
    }

    public void setY(T yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public T getY() {
        return yCoordinate;
    }

}
