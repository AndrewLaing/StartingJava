/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/12/2016.
 */

import java.io.*;
import java.text.DecimalFormat;


public class Challenge9
{
    public static void main(String[] args) throws Exception
    {
        int[] array1 =  {78,85,95,86,94,96,83,85,84,96,75,85};
        int[] array2 =  {58,86,34,83,99,92,81,90,87,94,83,81};
        int[] array3 =  {55,23,34,55,54,95,53,55,52,54,45,66};
        int[] array4 =  {37,33,37,33,34,73,78,81,72,72,71,72};
        int[] array5 =  {73,77,84,84,72,62,77,74,84,78,75,23};

        TestScores test1 = new TestScores(array1);
        TestScores test2 = new TestScores(array2);
        TestScores test3 = new TestScores(array3);
        TestScores test4 = new TestScores(array4);
        TestScores test5 = new TestScores(array5);

        TestScores[] tests = {test1, test2, test3, test4, test5};


        // Create the stream objects
        FileOutputStream outStream =
                new FileOutputStream("Objects.dat");
        ObjectOutputStream outputObjectFile =
                new ObjectOutputStream(outStream);

        // Write the serialised objects to the file
        for(int i=0; i<tests.length; i++)
        {
            outputObjectFile.writeObject(tests[i]);
        }

        // close the file
        outputObjectFile.close();

        System.out.println("The serialised TestScores objects were written to the " +
                "Objects.dat file.");


        // DESERIALISE ////////////////////////////////////////////
        DecimalFormat result = new DecimalFormat("#0.00");
        TestScores[] readIn = new TestScores[5];

        // Create the stream objects
        FileInputStream inStream =
                new FileInputStream("Objects.dat");
        ObjectInputStream inputObjectFile =
                new ObjectInputStream(inStream);

        // read the serialised objects from the file
        for(int i=0; i<readIn.length; i++)
        {
            readIn[i] = (TestScores) inputObjectFile.readObject();
        }

        inputObjectFile.close();

        for(int i=0; i<readIn.length; i++)
        {
            System.out.println("The average of test #" + (i+1) + " = "  + result.format(readIn[i].getAverage()));
        }


    }
}
