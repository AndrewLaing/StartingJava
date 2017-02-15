/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/02/2017.
 */
public class Challenge1
{
    public static void main(String[] args)
    {
        // create a list to hold Car objects
        ListType<Car> carList = new ListType<Car>();

        // create a few Car objects
        Car vw = new Car("227H54", "1997 Volkswagon");
        Car porsche = new Car("453B55", "2007 Porsche");
        Car bmw = new Car("177R60", "1980 BMW");

        // add the cars to the list
        carList.add(vw);
        carList.add(porsche);
        carList.add(bmw);

        // display the elements in the list
        System.out.println("Here are the elements in the list");
        displayList(carList);


        // create a list to hold Car objects
        ListType<Car> carList1 = new ListType<Car>();

        // create a few Car objects
        Car mazda = new Car("564S65", "2011 Mazda");
        Car honda = new Car("824H43", "2012 Honda Civic");
        Car daimler = new Car("899G44", "1956 Daimler");

        // add the cars to the list
        carList1.add(mazda);
        carList1.add(honda);
        carList1.add(daimler);

        // append the contents of this Carlist1 to Carlist
        carList.append(carList1);

        // display the elements in the list
        System.out.println("\nHere are the elements in the list with car list 1 added");
        displayList(carList);

        // create a list to hold Car objects
        ListType<Car> carList2 = new ListType<Car>();

        // add the cars to the list
        carList2.add(porsche);
        carList2.add(vw);
        carList2.add(daimler);

        // remove the contents of car list 2 from car list
        carList.remove(carList2);

        // display the contents of car list using an extended for loop
        System.out.println("\nHere are the elements in the list with car list 2 removed");
        for(Car c : carList)
            System.out.println(c);

    }


    public static void displayList(GenericList list)
    {
        for(int index=0; index<list.size(); index++)
            System.out.println("Index " + index + ": " + list.get(index));
    }
}
