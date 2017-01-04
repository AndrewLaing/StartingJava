/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/11/2016.
 */
public class ParkedCar
{
    private String make;
    private String model;
    private String colour;
    private String licencePlate;
    private int numberOfMinutesParked;


    /**
     * Copy Constructor
     * @param object2 The object to be copied
     */
    public ParkedCar(ParkedCar object2)
    {
        this.make = object2.getMake();
        this.model = object2.getModel();
        this.colour = object2.getColour();
        this.licencePlate = object2.getLicencePlate();
        this.numberOfMinutesParked = object2.getNumberOfMinutesParked();
    }


    /**
     * Constructor
     * @param make Make of the car
     * @param model Model of the car
     * @param colour Colour of the car
     * @param licencePlate Licence plate of the car
     * @param numberOfMinutesParked The number of minutes that the car has been parked
     */
    public ParkedCar(String make, String model, String colour, String licencePlate, int numberOfMinutesParked)
    {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.licencePlate = licencePlate;
        this.numberOfMinutesParked = numberOfMinutesParked;
    }


    public void setMake(String make) {
        this.make = make;
    }


    public String getMake() {
        return make;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getModel() {
        return model;
    }


    public void setColour(String colour) {
        this.colour = colour;
    }


    public String getColour() {
        return colour;
    }


    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }


    public String getLicencePlate() {
        return licencePlate;
    }


    public void setNumberOfMinutesParked(int numberOfMinutesParked) {
        this.numberOfMinutesParked = numberOfMinutesParked;
    }


    public int getNumberOfMinutesParked() {
        return numberOfMinutesParked;
    }


    public String toString()
    {
        return "\nParked Car" +
                "\n  Make: " + make +
                "\n  Model: " + model +
                "\n  Colour: " + colour +
                "\n  Licence Plate: " + licencePlate +
                "\n  Minutes Parked: " + numberOfMinutesParked + "\n";
    }

}
