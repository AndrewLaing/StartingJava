/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class Person
{
    private String name;
    private String address;;
    private String telephoneNumber;

    public Person()
    {
        this.name = "";
        this.address = "";
        this.telephoneNumber = "";
    }

    public Person(Person object2)
    {
        this.name = object2.getName();
        this.address = object2.getAddress();
        this.telephoneNumber = object2.getTelephoneNumber();
    }

    public Person(String name, String address, String telephoneNumber)
            {
        this.name =name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}
