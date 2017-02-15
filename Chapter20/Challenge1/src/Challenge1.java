/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/02/2017.
 */
public class Challenge1
{
    public static void main(String[] args)
    {
        GenericDLinkedList<Double> ll = new GenericDLinkedList<Double>();
        ll.add(9.2);
        ll.add(4.2);
        ll.add(6.2);
        ll.add(8.3);
        ll.add(4.3);
        System.out.println("The members of the list are:");
        System.out.println(ll);


        ll.remove(6.2);
        System.out.println("\nThe members of the list after removing 6.2 are:");
        System.out.println(ll);


        ll.remove(2);
        System.out.println("\nThe members of the list after removing the node at index 2:");
        System.out.println(ll);


        ll.clear();
        System.out.println("\nThe members of the list after using clear():");
        System.out.println(ll);
        System.out.println("Size = " + ll.size());

        ll.add(9.2);
        ll.add(4.2);
        ll.add(6.2);
        ll.add(8.3);
        ll.add(4.3);
        System.out.println("\nThe members of the list after adding new items are:");
        System.out.println(ll);

        System.out.println("\nThe element at index 2 is: " + ll.get(2));


        System.out.println("\nThe element replaced at index 3 is: " + ll.set(3, 11.2));
        System.out.println("The members of the list after setting index 3 are:");
        System.out.println(ll);
    }
}
