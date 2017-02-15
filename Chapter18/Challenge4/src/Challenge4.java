/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */

import java.util.Scanner;

public class Challenge4
{
    public static void main(String[] args)
    {
        // create a Scanner object
        Scanner keyboard = new Scanner(System.in);
        String input;

        // Create some Stock objects
        Stock xyzCompany = new Stock("XYZ", 9.62);
        Stock larryHomes = new Stock("LHS", 14.45);
        Stock bartonFink = new Stock("BFK", 11.61);
        Stock sunLtd = new Stock("SUN", 22.98);
        Stock alphabet = new Stock("GOO", 32.01);
        Stock nemesis = new Stock("NMS", 6.66);
        Stock finkBros = new Stock("FBS", 15.65);

        // create a StockMap
        StockMap smp = new StockMap();

        // add some Stocks to the StockMap
        smp.add(xyzCompany.getSymbol(),xyzCompany);
        smp.add(larryHomes.getSymbol(),larryHomes);
        smp.add(bartonFink.getSymbol(),bartonFink);
        smp.add(sunLtd.getSymbol(),sunLtd);
        smp.add(alphabet.getSymbol(),alphabet);
        smp.add(nemesis.getSymbol(),nemesis);
        smp.add(finkBros.getSymbol(),finkBros);

        // Ask the user for an Stock Symbol to search for
        System.out.println("Enter the Stock Symbol to search for: ");
        input = keyboard.nextLine();

        Stock result = smp.search(input);

        if(result!=null)
            System.out.println(result);
        else
            System.out.println("Stock " + input + " not found");
    }
}
