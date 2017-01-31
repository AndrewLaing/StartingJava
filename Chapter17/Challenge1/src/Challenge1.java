/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/01/2017.
 */
public class Challenge1
{
    public static void main(String[] args)
    {
        MyList<Double> myList = new MyList<Double>();

        Double a = new Double(23.3);
        Double b = new Double(3.1);
        Double c = new Double(2.5);
        Double d = new Double(123.6);
        Double e = new Double(213.7);
        Double f = new Double(134.3);
        Double g = new Double(11.31);

        myList.add(a);
        myList.add(b);
        myList.add(c);
        myList.add(d);
        myList.add(e);
        myList.add(f);
        myList.add(g);

        System.out.println("The largest item in myList is " + myList.largest());
        System.out.println("The smallest item in myList is " + myList.smallest());


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

        MyList myList2 = new MyList<>();
        myList2.add(a);
        myList2.add(b);
        myList2.add(c);
        myList2.add(d1);
        myList2.add(e1);
        myList2.add(f1);
        myList2.add(g1);

        System.out.println("The largest item in myList2 is " + myList2.largest());
        System.out.println("The smallest item in myList2 is " + myList2.smallest());
    }
}
