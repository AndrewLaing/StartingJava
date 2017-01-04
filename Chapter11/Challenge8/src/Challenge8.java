/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/12/2016.
 */
public class Challenge8
{
    public static void main(String[] args)
    {
        Customer customer1 = new Customer();
        customer1.setName("Nathan Rigby");
        customer1.setAddress("245 Lexington Avenue");
        customer1.setTelephoneNumber("254 123 1254");
        customer1.setCustomerNumber(151003);
        customer1.setOnMailingList(true);

        PreferredCustomer preferred1 = new PreferredCustomer(customer1, 2500);

        System.out.println(preferred1);
    }
}
