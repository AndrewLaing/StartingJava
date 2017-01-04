/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/08/2016.
 */
public class Challenge2 {
    public static void main(String[] args) {
        String firstName="Andrew", middleName="William", lastName="Laing";
        char firstInitial = firstName.charAt(0);
        char middleInitial = middleName.charAt(0);
        char lastInitial = lastName.charAt(0);

        System.out.print("Hello my name is " + firstName + " " +
                          middleName + " " + lastName + "\n");
        System.out.print("and my initials are " + firstInitial + "." +
                          middleInitial + "." + lastInitial + ".\n");
    }
}
