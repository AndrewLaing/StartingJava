/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/10/2016.
 */
public class Challenge3
{
    public static void main(String[] args)
    {
        PersonalInformation me    = new PersonalInformation("Andrew Laing",  "22 Rue Schmoo",    27, "01-811-8054");
        PersonalInformation bob   = new PersonalInformation("Bob Grue",      "1587 Biker Grove", 27, "0145-654-2844");
        PersonalInformation alice = new PersonalInformation("Alice Bottler", "321 Dusty Road",   27, "0935-925-9854");

        System.out.println("Name: " + me.getName() + "\nAddress: " + me.getAddress() +
                           "\nAge: " + me.getAge() + "\nPhoneNo: " + me.getPhoneNumber());


        System.out.println("\nName: " + bob.getName() + "\nAddress: " + bob.getAddress() +
                           "\nAge: " + bob.getAge() + "\nPhoneNo: " + bob.getPhoneNumber());

        System.out.println("\nName: " + alice.getName() + "\nAddress: " + alice.getAddress() +
                           "\nAge: " + alice.getAge() + "\nPhoneNo: " + alice.getPhoneNumber());

    }
}
