/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/12/2016.
 */

import javax.swing.JOptionPane;

public class Challenge12
{
    public static void main(String[] args) {

        String toCount = "the dog jumped over the fence";
        char[] toConvert = {'h','e','l','l','o',' ','f','r','o','m',' ','S','t','r','i','n','g','O','p','s'};

        String result = "";

        int wc = StringOps.WordCount(toCount);
        String converted = StringOps.arrayToString(toConvert);
        char mostFreq = StringOps.mostFrequent(toCount);
        String replaced = StringOps.replaceSubstring(toCount, "the", "that");

        result += "There are " + wc + " words in the first string.";
        result += "\nThe converted string reads - " + converted;
        result += "\nThe most frequent character is '" + mostFreq + "'" ;
        result += "\nThe replaced string reads - " + replaced;

        JOptionPane.showMessageDialog(null, result);

        System.exit(0);


    }
}
