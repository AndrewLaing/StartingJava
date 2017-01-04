/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */
public class RoomCarpet {
    private RoomDimension size;
    private double carpetCost;

    public RoomCarpet(RoomDimension roomSize, double cost)
    {
        size = roomSize;
        carpetCost = cost;
    }


    public RoomCarpet(RoomCarpet object2)
    {
        size = object2.size;
        carpetCost = object2.carpetCost;
    }

    public RoomDimension getSize() {
        return size;
    }

    public void setSize(RoomDimension roomSize)
    {
        size = roomSize;
    }

    public double getCarpetCost() {
        return carpetCost;
    }

    public void setCarpetCost(double cost) {
        carpetCost = cost;
    }

    public double getTotalCost()
    {
        return size.getArea() * carpetCost;
    }

    public String toString() {
        return "Room Carpet: " +
                "\n Carpet cost: " + carpetCost + "\n" +
                size;
    }

    public boolean equals(RoomCarpet object2)
    {
        if(size.equals(object2.size)) {
            if(carpetCost == object2.carpetCost)
                return true;
        }

        return false;
    }
}
