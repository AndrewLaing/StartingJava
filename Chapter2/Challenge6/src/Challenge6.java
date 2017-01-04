/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/08/2016.
 */
public class Challenge6 {
    public static void main(String[] args) {
        final double percentageOfTotalSales = 0.62;
        double totalSales = 4.6;
        double predictedSalesGenerated = totalSales * percentageOfTotalSales;

        System.out.println("It is predicted that the company will\n" +
                           "generate $" + predictedSalesGenerated + " million in sales.");
    }
}
