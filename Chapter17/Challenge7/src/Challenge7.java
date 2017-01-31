/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/01/2017.
 */

import java.text.DecimalFormat;

public class Challenge7
{
    public static void main(String[] args)
    {
        DecimalFormat fmt = new DecimalFormat("#0.00");

        Double[] dubs = {32.4, 65.4, 584.3, 5.5, 654.2, 12.7};
        MyList<Double> myList = new MyList<Double>(dubs);

        System.out.println("The largest item in myList is " + myList.highest());
        System.out.println("The smallest item in myList is " + myList.lowest());
        System.out.println("The total is " + myList.total());
        System.out.println("The average value is " + fmt.format(myList.average()));

        System.out.println();

        Integer[] intArray = {564, 5, 65, 987, 69, 352, 3};
        MyList<Integer> myList1 = new MyList<Integer>(intArray);

        System.out.println("The largest item in myList is " + myList1.highest());
        System.out.println("The smallest item in myList is " + myList1.lowest());
        System.out.println("The total is " + myList1.total());
        System.out.println("The average value is " + fmt.format(myList1.average()));

    }
}
