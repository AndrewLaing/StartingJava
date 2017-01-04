/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/12/2016.
 */
public class Challenge9
{
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount(150.0, 7.5);


        SavingsAccount savings1 = new SavingsAccount(account1);

        System.out.println(savings1);

        savings1.withdraw(10.0);
        savings1.withdraw(40.0);
        savings1.withdraw(10.0);
        savings1.withdraw(40.0);
        savings1.withdraw(10.0);
        savings1.withdraw(30.0);



        System.out.println("\n---- After cumulative withdrawals totaling £140.00. ---- \n");
        System.out.println(savings1);


        savings1.deposit(40.0);
        System.out.println("\n---- After a deposit of £40.00. ---- \n");
        System.out.println(savings1);


        savings1.monthlyProcess();
        System.out.println("\n---- After the Monthly Process. ---- \n");
        System.out.println(savings1);

    }
}
