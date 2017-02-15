/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/02/2017.
 */
public class Challenge2
{
    public static void main(String[] args)
    {
        // create a list to hold Car objects
        ListType<Car> carList = new ListType<Car>();

        // create a few Car objects
        Car vw = new Car("227H54", "1997 Volkswagon");
        Car porsche = new Car("453B55", "2007 Porsche");
        Car bmw = new Car("177R60", "1980 BMW");

        carList.add(vw);
        carList.add(porsche);
        carList.add(bmw);

        // display the capacity of the list
        System.out.println("The current capacity of the list is " + carList.getCapacity());

        // ensure the list can hold 100 car objects
        carList.ensureCapacity(100);

        // display the capacity of the list
        System.out.println("The list now ensures the storage of " + carList.getCapacity() + " Car objects");

        // trim the list to the size of the number of elements in it
        carList.trimToSize();

        // display the capacity of the list
        System.out.println("The list is now trimmed to hold " + carList.getCapacity() + " Car objects");
    }
}
