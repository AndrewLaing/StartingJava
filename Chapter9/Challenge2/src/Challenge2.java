/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/11/2016.
 */
public class Challenge2
{
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount(5000.25);
        BankAccount account2 = new BankAccount(account1);

        System.out.println( "The balance of account 1 is " +
                account1.getBalance() );


        System.out.println( "The balance of account 2 is " +
                account2.getBalance() );

    }
}
