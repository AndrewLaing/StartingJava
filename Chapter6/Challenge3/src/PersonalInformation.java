/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/10/2016.
 */
public class PersonalInformation
{
    private String name;
    private String address;
    private int age;
    private String phoneNumber;


    /**
     * No-arg constructor
     */
    public PersonalInformation()
    {
        name = "Unknown";
        address = "Unknown";
        age = 0;
        phoneNumber = "Unknown";
    }


    /**
     * Overloaded constructor
     * @param n The person's name
     * @param addr The person's address
     * @param a The person's age
     * @param pn The person's phone number
     */
    public PersonalInformation(String n, String addr, int a, String pn)
    {
        name = n;
        address = addr;
        age = a;
        phoneNumber = pn;
    }


    /**
     * The method setName sets the value of the name field
     * @param n The person's name
     */
    public void setName(String n)
    {
        name = n;
    }


    /**
     * The method setAddress sets the value of the address field
     * @param addr The person's address
     */
    public void setAddress(String addr)
    {
        address = addr;
    }


    /**
     * The metho0d setAge sets the value of the age field
     * @param a The person's age
     */
    public void setAge(int a)
    {
        age = a;
    }


    /**
     * The method setPhoneNumber sets the value of the phoneNumber field
     * @param pn The person's phone number
     */
    public void setPhoneNumber(String pn)
    {
        phoneNumber = pn;
    }


    /**
     * The method getName returns the value in the name field
     * @return The value in the name field
     */
    public String getName()
    {
        return name;
    }


    /**
     * The method getAddress returns the value in the address field
     * @return The value in the address field
     */
    public String getAddress()
    {
        return address;
    }


    /**
     * The method getAge returns the value in the age field
     * @return The value in the age field
     */
    public int getAge()
    {
        return age;
    }


    /**
     * The method getPhoneNumber returns the value in the phoneNumber field
     * @return The value in the phoneNumber field
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
}
