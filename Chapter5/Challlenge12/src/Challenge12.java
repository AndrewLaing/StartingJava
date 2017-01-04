/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   18/09/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge12 {

    public static void main(String[] args)
    {
        DecimalFormat dollars = new DecimalFormat("#,##0.00");

        float mass;        // to hold the mass of the object
        float velocity;    // to hold the velocity of the object
        float KE;          // to hold the kinetic energy of the object

        // Get the user to input the mass and velocity of the object
        mass = getMass();
        velocity = getVelocity();

        // Calculate the kinetic energy of the object
        KE = kineticEnergy(mass, velocity);

        // Display the calculated kinetic energy of the object
        JOptionPane.showMessageDialog(null, "The object's Kinetic Energy is " +
                dollars.format(KE));

        // Close the thread created by the message dialogue
        System.exit(0);
    }


    /**
     * The method getMass gets the user to input
     * the mass of the object
     * @return The mass of the object as a float
     */
    public static float getMass()
    {
        String input;       // to hold the user's input
        float mass;        // to hold the objects mass

        input = JOptionPane.showInputDialog("Enter the object's mass in kilograms:");
        mass = Float.parseFloat(input);

        return mass;
    }


    /**
     * The method getVelocity gets the user to input
     * the velocity of the object
     * @return The velocity of the object as a float
     */
    public static float getVelocity()
    {
        String input;       // to hold the user's input
        float velocity;     // to hold the object's velocity in meters per second

        input = JOptionPane.showInputDialog("Enter the object's velocity in meters per second:");
        velocity = Float.parseFloat(input);

        return velocity;
    }


    /**
     *  The method kineticEnergy calculates and return the
     *  Kinetic Energy of the moving object
     * @param mass The object's mass in Kilograms
     * @param velocity The object's velocity in meters per second
     * @return The amount of Kinetic Energy that the object has
     */
    public static float kineticEnergy(float mass, float velocity)
    {
        return 0.5F * (mass * (velocity * velocity));
    }

}
