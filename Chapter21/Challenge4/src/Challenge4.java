import java.io.IOException;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/02/2017.
 */
public class Challenge4 {



    public static void main(String[] args) throws IOException
    {

        DelimiterChecker dlc = new DelimiterChecker();

//        String correct   = "[sa[at]aaassa]sat{{afta}ta}t(atta(ta)ta)ta";
//        String incorrect = "[sa[at]aaas]]sasat{{afta}ta}t(atta(ta)ta)ta";
//        String incorrect2    = "[pa[ataaassasat{{afta}tat(atta(tatata";
//
//        System.out.println("First the correct string");
//        dlc.parseString(correct);
//        System.out.println("\nNow the incorrect string");
//        dlc.parseString(incorrect);
//        System.out.println("\nNow the incorrect2 string");
//        dlc.parseString(incorrect2);

        dlc.parseFile("testFile.txt");
    }
}
