/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/11/2016.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PoliceOfficer
{
    private String name;
    private String badgeNumber;

    private ArrayList<ParkingTicket> ticketsToWrite = new ArrayList();


    /**
     * Copy constructor
     * @param object2 The object to be copied
     */
    public PoliceOfficer(PoliceOfficer object2)
    {
        this.name = object2.getName();
        this.badgeNumber = object2.getBadgeNumber();
    }


    public PoliceOfficer(String name, String badgeNumber)
    {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }


    public String getBadgeNumber() {
        return badgeNumber;
    }


    public String toString() {
        return "Police Officer:" +
                "\n Name: " + name +
                "\n Badge number: " + badgeNumber;
    }


    /**
     * The method isIllegally parked checks whether the car has been parked for longer
     * that the owner has bought a ticket to park for
     * @param carToExamine the car for the police officer to examine
     * @param meterToExamine  the parking meter for the police officer to examine
     * @return
     */
    public boolean isIllegallyParked(ParkedCar carToExamine, ParkingMeter meterToExamine)
    {
        return carToExamine.getNumberOfMinutesParked() > meterToExamine.getMinutesParked();
    }


    public void issueParkingTicket(ParkedCar carToExamine, ParkingMeter meterToExamine)
    {
        if(!isIllegallyParked(carToExamine, meterToExamine)) {
            System.out.println("Nothing to do here the car is legally parked.");
            return;
        }
    }


    public void examineVehicles()
    {
        Scanner keyboard = new Scanner(System.in);

        String input;       // to hold use input

        String make, model, colour, licencePlate;
        int numberOfMinutesParked;
        int minutesParked;

        while (true)
        {
            // Check first whether the officer wants to check another vehicle or not
            System.out.print( "Press <ENTER> to check a vehicle"+
                    "\nor type in 'quit' to go off duty: ");
            input = keyboard.nextLine();
            if(input.toLowerCase().equals("quit"))
                return;

            System.out.print("\nEnter the make of the vehicle: ");
            make = keyboard.nextLine();



            System.out.print("Enter the model of the vehicle: ");
            model = keyboard.nextLine();

            System.out.print("Enter the colour of the vehicle: ");
            colour = keyboard.nextLine();

            System.out.print("Enter the licence plate of the vehicle: ");
            licencePlate = keyboard.nextLine();

            System.out.print("Enter the number of minutes that the" +
                    "\nvehicle has been parked: ");
            input = keyboard.nextLine();
            numberOfMinutesParked = Integer.parseInt(input);

            System.out.print("Enter the number of minutes purchased from the meter: ");
            input = keyboard.nextLine();
            minutesParked = Integer.parseInt(input);

            ParkedCar carToExamine = new ParkedCar(make,model,colour,licencePlate, numberOfMinutesParked);
            ParkingMeter meterToExamine = new ParkingMeter(minutesParked);

            if( isIllegallyParked(carToExamine, meterToExamine) )
            {

                ParkingTicket writeTicket = new ParkingTicket(carToExamine, meterToExamine, name, badgeNumber);
                ticketsToWrite.add(writeTicket);
                System.out.println("\nCar illegally parked. Writing ticket.\n\n");
            }
            else
            {
                System.out.println("\nNothing to do here, the car is legally parked.\n");
            }
        }
    }


    public void printTickets()
    {
        for(int i=0; i<ticketsToWrite.size(); i++)
        {
            System.out.println(ticketsToWrite.get(i));
        }
    }

}
