/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/12/2016.
 */
public class Customer extends Person
{
    private int customerNumber;
    private boolean onMailingList;

    public Customer()
    {
        super();
        customerNumber = 0;
        onMailingList = false;
    }

    public Customer(Customer object2)
    {
        super(object2.getName(), object2.getAddress(), object2.getTelephoneNumber());
        this.customerNumber = object2.getCustomerNumber();
        this.onMailingList = object2.getOnMailingList();
    }

    public Customer(Person person, int customerNumber, boolean onMailingList)
    {
        super(person.getName(), person.getAddress(), person.getTelephoneNumber());
        this.customerNumber = customerNumber;
        this.onMailingList = onMailingList;
    }


    public Customer(String name, String address, String telephoneNumber,
                    int customerNumber, boolean onMailingList)
    {
        super(name, address, telephoneNumber);
        this.customerNumber = customerNumber;
        this.onMailingList = onMailingList;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setOnMailingList(boolean onMailingList) {
        this.onMailingList = onMailingList;
    }

    public boolean getOnMailingList()
    {
        return onMailingList;
    }


    public String toString() {
        return "Customer Number: " + getCustomerNumber() +
                "\nOn Mailing List: " + (getOnMailingList() ? "TRUE" : "FALSE") +
                "\nName: " + getName() +
                "\nAddress: " + getAddress() +
                "\nTelephone Number: " + getTelephoneNumber();
    }
}
