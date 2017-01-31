/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/01/2017.
 */
public class Challenge2
{
    public static void main(String[] args)
    {
        MyList<String> myList = new MyList<String>();

        String a = new String("Brian");
        String b = new String("John");
        String c = new String("Johan");
        String d = new String("Zoe");
        String e = new String("Alan");
        String f = new String("Alice");
        String g = new String("Fred");

        myList.add(a);
        myList.add(b);
        myList.add(c);
        myList.add(d);
        myList.add(e);
        myList.add(f);
        myList.add(g);

        System.out.println("The largest item in myList is " + myList.largest());
        System.out.println("The smallest item in myList is " + myList.smallest());


        // Note: Integer implements Comparable but Number does not
        MyList<Integer> myList1 = new MyList<Integer>();

        Integer a1 = new Integer(23);
        Integer b1 = new Integer(3);
        Integer c1 = new Integer(2);
        Integer d1 = new Integer(123);
        Integer e1 = new Integer(213);
        Integer f1 = new Integer(134);
        Integer g1 = new Integer(11);

        myList1.add(a1);
        myList1.add(b1);
        myList1.add(c1);
        myList1.add(d1);
        myList1.add(e1);
        myList1.add(f1);
        myList1.add(g1);

        System.out.println("The largest item in myList1 is " + myList1.largest());
        System.out.println("The smallest item in myList1 is " + myList1.smallest());

    }
}
