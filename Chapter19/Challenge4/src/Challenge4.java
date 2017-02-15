/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/02/2017.
 */
public class Challenge4
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
        carList.add(porsche);
        carList.add(porsche);
        carList.add(bmw);
        carList.add(vw);
        carList.add(vw);
        carList.add(bmw);
        carList.add(porsche);

        // display the contents of the list
        System.out.println("--- Here are the contents of carList ---");
        for(Car c : carList)
            System.out.println(c);

        // remove this range from the list
        carList.removeRange(3, 7);

        // display the contents of the list
        System.out.println("--- Now the contents after removing range 3-7 ---");
        for(Car c : carList)
            System.out.println(c);
    }
}
