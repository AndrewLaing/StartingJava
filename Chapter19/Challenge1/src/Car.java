/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/01/2017.
 */
public class Car
{
    private String vin;
    private String description;

    public Car(String v, String desc)
    {
        vin = v;
        description = desc;
    }

    public String getVin() {
        return vin;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "VIN: " + vin +
                "\tDescription: " + description;
    }

    public int hashCode() {
        return vin.hashCode();
    }


    public boolean equals(Object obj) {
        // make sure the object is a Car
        if(obj instanceof Car)
        {
            // get a Car reference to obj
            Car tempCar = (Car) obj;

            // compare the two VINs. If the two VINs are the same
            // then they are the same car
            if(vin.equalsIgnoreCase(tempCar.vin))
                return true;
            else
                return false;
        }
        else
           return false;
    }
}
