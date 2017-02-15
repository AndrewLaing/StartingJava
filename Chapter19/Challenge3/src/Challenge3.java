/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/02/2017.
 */
public class Challenge3
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

        // display the contents of the list
        System.out.println("--- Here are the contents of carList ---");
        for(Car c : carList)
            System.out.println(c);

        // create carList1 as a copy of carList using the copy Constructor
        ListType<Car> carList1 = new ListType<Car>(carList);

        // display the contents of the list
        System.out.println("\n--- Here are the contents of carList1 ---");
        for(Car c : carList1)
            System.out.println(c);

        // get the lastIndexOf the porsche in the list
        System.out.println("The last occurence of the posrche in the list\n" +
                            "is at index " + carList.lastIndexOf(porsche));




    }
}
