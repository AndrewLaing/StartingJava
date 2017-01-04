/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class Challenge4
{
    public static void main(String[] args)
    {
        try {
            Month test1 = new Month("May");
            System.out.println("The month of test1 is " + test1.getMonthName());
        }
        catch(InvalidMonthException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            Month test2 = new Month("Moocows");
            System.out.println("The month of test2 is " + test2.getMonthName());
        }
        catch(InvalidMonthException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            Month test3 = new Month(10);
            System.out.println("The month of test3 is " + test3.getMonthName());
        }
        catch(InvalidMonthException e)
        {
            System.out.println(e.getMessage());
        }


        try {
            Month test4 = new Month(44);
            System.out.println("The month of test4 is " + test4.getMonthName());
        }
        catch(InvalidMonthException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
