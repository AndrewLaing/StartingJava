/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/08/2016.
 */


import javax.swing.JOptionPane;

public class Challenge12 {
    public static void main(String[] args) {
        String inputString, lowerCity, upperCity;
        int cityLen;
        char firstChar;

        inputString = JOptionPane.showInputDialog("Please, enter the name of a city");

        upperCity   = inputString.toUpperCase();
        lowerCity   = inputString.toLowerCase();
        cityLen     = inputString.length();
        firstChar   = inputString.charAt(0);

        String result = String.format("City name: %s\nLower case: %s\nUpper case: %s\nLength of name: %d\nFirst letter: %c", inputString,lowerCity,upperCity,cityLen,firstChar);

        JOptionPane.showMessageDialog(null, result);

        System.exit(0);
    }
}
