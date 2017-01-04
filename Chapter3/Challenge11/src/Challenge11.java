/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/08/2016.
 */

import javax.swing.JOptionPane;

public class Challenge11 {
    public static void main(String[] args) {
        String input;           // To hold  the user's input
        String result="1st: ";  // To hold the result string
        String[] names = new String[3];
        double[] times = new double[3];

        for(int i=0; i<3; i++) {
            names[i] = JOptionPane.showInputDialog("Enter the name of runner " + Integer.toString(i+1));
            input = JOptionPane.showInputDialog("Enter the finish time of runner " + Integer.toString(i+1));
            times[i] = Double.parseDouble(input);
        }

        int first=0, last=0, middle=0;
        double fastest=times[0], slowest=times[0];

        // Calculate first and last place
        for(int i=1; i<3; i++) {
            if(times[i]<fastest) {
                fastest = times[i];
                first = i;
            }
            if(times[i]>slowest) {
                slowest = times[i];
                last = i;
            }
        }

        // If all times are the same then first == last
        if(first==last)
            last = 2;

        // Calculate middle place
        for(int i=0; i<3; i++) {
            if (i!=first && i!=last) {
                middle=i;
            }
        }

        // Create the result string
        result += names[first] + "\n2nd: " + names[middle] + "\n3rd: " + names[last];

        // Display the result
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the message
        System.exit(0);
    }
}
