/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/12/2016.
 */
public class Challenge3
{
    public static void main(String[] args)
    {
        try {
            RetailItem item1 = new RetailItem("Jacket", -12, 59.95);
            System.out.printf("Item #1\t\t%s\t\t\t%d\t\t%.2f\n", item1.getDescription(), item1.getUnitsOnHand(), item1.getPrice());
        }
        catch (NegativePriceException e){
            System.out.println(e.getMessage());
        }
        catch (NegativeUnitsException e)
        {
            System.out.println(e.getMessage());
        }


        try {
            RetailItem item2 = new RetailItem("Designer Jeans", 40, -34.95);
            System.out.printf("Item #2\t\t%s\t%d\t\t%.2f\n", item2.getDescription(), item2.getUnitsOnHand(), item2.getPrice());
        }
        catch (NegativePriceException e){
            System.out.println(e.getMessage());
        }
        catch (NegativeUnitsException e)
        {
            System.out.println(e.getMessage());
        }

        try {
            RetailItem item3 = new RetailItem("Shirt", 20, 24.95);
            System.out.printf("Item #3\t\t%s\t\t\t%d\t\t%.2f\n", item3.getDescription(), item3.getUnitsOnHand(), item3.getPrice());
        }
        catch (NegativePriceException e){
            System.out.println(e.getMessage());
        }
        catch (NegativeUnitsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
