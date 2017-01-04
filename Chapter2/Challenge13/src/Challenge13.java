/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/08/2016.
 */

import javax.swing.JOptionPane;

public class Challenge13 {
    public static void main(String[] args) {
        String inputString;                                         // Used to input the users age
        String name, city, college, profession, animal, petName;    // Used to store ...
        int age;                                                    // ... the user's input

        // Show the welcome message
        JOptionPane.showMessageDialog(null, "Let's play a game");

        // Get the user's input
        name = JOptionPane.showInputDialog("Enter a name");
        inputString = JOptionPane.showInputDialog("Enter his/her/it's age");
        age = Integer.parseInt(inputString);
        city = JOptionPane.showInputDialog("Enter the name of a city");
        college = JOptionPane.showInputDialog("Enter the name of a college");
        profession = JOptionPane.showInputDialog("Enter the name of a profession");
        animal = JOptionPane.showInputDialog("Enter the name of an animal");
        petName = JOptionPane.showInputDialog("Enter a pet's name");

        // Create the result string
        String result = String.format("There once was a person called %s who lived in %s.\n", name, city);
        result += String.format("At the age of %d, %s went to college at %s.\n", age, name,college);
        result += String.format("%s graduated and went to work as a %s.\n",name,profession);
        result += String.format("Then, %s adopted a(n) %s named %s.\n",name,animal,petName);
        result += String.format("They both lived happily ever after.");

        // Display the result to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the message box process
        System.exit(0);
    }
}
