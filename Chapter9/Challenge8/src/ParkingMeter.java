/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/11/2016.
 */
public class ParkingMeter
{
    private int minutesParked;

    public ParkingMeter(ParkingMeter object2)
    {
        this.minutesParked = object2.getMinutesParked();
    }

    public ParkingMeter(int minutesParked)
    {
        this.minutesParked = minutesParked;
    }

    public void setMinutesParked(int minutesParked) {
        this.minutesParked = minutesParked;
    }

    public int getMinutesParked() {
        return minutesParked;
    }

    public String toString() {
        return "\nParking Meter\n  Minutes parked: " + minutesParked + "\n";
    }
}
