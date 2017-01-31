/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/01/2017.
 */
public class Challenge6
{
    public static void main(String[] args)
    {
        String[] names = {"Brian","John","Johan","Zoe","Alan","Alice","Fred"};
        MyList<String> myList = new MyList<String>(names);

        System.out.println("The highest value item in myList is " + myList.highest());
        System.out.println("The lowest value item in myList is " + myList.lowest());

        Integer[] nums = {2,55,23,66,98,111,212,22,232,5,67};
        MyList<Integer> myList1 = new MyList<Integer>(nums);

        System.out.println("The highest value item in myList is " + myList1.highest());
        System.out.println("The lowest value item in myList is " + myList1.lowest());
        }
}
