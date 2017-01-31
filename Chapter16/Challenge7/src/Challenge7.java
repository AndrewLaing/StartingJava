/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/01/2017.
 */
public class Challenge7
{
    public static void main(String[] args)
    {
        int numbers[] = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                         8080152, 4562555, 5552012, 5050522, 7825877, 1250255,
                         1005231, 6545231, 3852085, 7576651, 7881200, 4581002,
                         4525356, 5578842, 6645854, 9999999, 0000000, 2536459
        };

        int toFind1 = 0000000;
        int toFind2 = 9999999;
        int toFind3 = 5050522;

        IntQuickSorter.quickSort(numbers);

        IntBinarySearcher.setComparisonsMade(0);
        IntSequentialSearcher.setComparisonsMade(0);

        IntSequentialSearcher.search(numbers, toFind1);
        System.out.println("Sequential search made " + IntSequentialSearcher.getComparisonsMade() +
                            " comparisons to find " + toFind1);

        IntBinarySearcher.search(numbers, toFind1);
        System.out.println("Binary search made " + IntBinarySearcher.getComparisonsMade() +
                " comparisons to find " + toFind1);


        System.out.println();

        IntBinarySearcher.setComparisonsMade(0);
        IntSequentialSearcher.setComparisonsMade(0);

        IntSequentialSearcher.search(numbers, toFind2);
        System.out.println("Sequential search made " + IntSequentialSearcher.getComparisonsMade() +
                " comparisons to find " + toFind2);

        IntBinarySearcher.search(numbers, toFind2);
        System.out.println("Binary search made " + IntBinarySearcher.getComparisonsMade() +
                " comparisons to find " + toFind2);


        System.out.println();

        IntBinarySearcher.setComparisonsMade(0);
        IntSequentialSearcher.setComparisonsMade(0);

        IntSequentialSearcher.search(numbers, toFind3);
        System.out.println("Sequential search made " + IntSequentialSearcher.getComparisonsMade() +
                " comparisons to find " + toFind3);

        IntBinarySearcher.search(numbers, toFind3);
        System.out.println("Binary search made " + IntBinarySearcher.getComparisonsMade() +
                " comparisons to find " + toFind3);


    }
}
