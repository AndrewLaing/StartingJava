/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/08/2016.
 */
public class Challenge4 {
    public static void main(String[] args) {
        String stars  = "*******";
        String spaces = "   ";

        System.out.println(spaces + stars.substring(0,1));
        System.out.println(spaces.substring(0,2) + stars.substring(0,3));
        System.out.println(spaces.substring(0,1) + stars.substring(0,5));
        System.out.println(stars);
        System.out.println(spaces.substring(0,1) + stars.substring(0,5));
        System.out.println(spaces.substring(0,2) + stars.substring(0,3));
        System.out.println(spaces + stars.substring(0,1));
    }
}
