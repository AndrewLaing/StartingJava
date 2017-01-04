/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/11/2016.
 */

import java.text.DecimalFormat;

public class ParkingTicket
{
    private ParkedCar illegallyParkedCar;
    private ParkingMeter meterUsed;

    private String officersName;
    private String officersBadgeNumber;
    private double totalFine;


    public ParkingTicket(ParkingTicket object2)
    {
        this.illegallyParkedCar = new ParkedCar(object2.getIllegallyParkedCar());
        this.meterUsed = new ParkingMeter(object2.getMeterUsed());

    }


    public ParkingTicket(ParkedCar illegallyParkedCar, ParkingMeter meterUsed,
                            String officersName, String officersBadgeNumber)
    {
        this.illegallyParkedCar = new ParkedCar(illegallyParkedCar);
        this.meterUsed = new ParkingMeter(meterUsed);
        this.officersName = officersName;
        this.officersBadgeNumber = officersBadgeNumber;
        this.totalFine = calculateFine();
    }


    public void setIllegallyParkedCar(ParkedCar illegallyParkedCar) {
        this.illegallyParkedCar = illegallyParkedCar;
    }


    public ParkedCar getIllegallyParkedCar() {
        return illegallyParkedCar;
    }


    public void setMeterUsed(ParkingMeter meterUsed) {
        this.meterUsed = meterUsed;
    }


    public ParkingMeter getMeterUsed() {
        return meterUsed;
    }


    public void setTotalFine(double totalFine) {
        this.totalFine = totalFine;
    }


    public double getTotalFine() {
        return totalFine;
    }


    public String getCarDetails()
    {
        return illegallyParkedCar.toString();
    }


    public double calculateFine()
    {
        double totalFine = 0.0;
        int hoursOverPaidHours = illegallyParkedCar.getNumberOfMinutesParked();

        // The fine starts at £25 for the first hour (or part of) that the car
        //      is illegally parked
        hoursOverPaidHours -= meterUsed.getMinutesParked();
        if(hoursOverPaidHours>0)
            totalFine += 25;

        // The fine is then charged at £10 for each hour or part of.
        hoursOverPaidHours -=60;

        while(hoursOverPaidHours>0)
        {
            totalFine += 10.0;
            hoursOverPaidHours -=60;
        }

        return totalFine;
    }


    public String toString()
    {
        DecimalFormat pounds = new DecimalFormat("£#0.00");

        return "\n----- Parking Ticket -----" +
                getIllegallyParkedCar() +
                getMeterUsed() +
                "\nIssuing Officer: " +
                "\n  Name: " + officersName +
                "\n  Badge Number: " + officersBadgeNumber +
                "\n\nTotal Fine: " + pounds.format(totalFine)
                + "\n--------------------------\n";
    }
}
