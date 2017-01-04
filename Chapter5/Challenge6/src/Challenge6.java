/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   14/09/2016.
 */
public class Challenge6
{
    public static void main(String[] args)
    {
        float degreesInCentigrade;

        System.out.println("Fahrenheit\tCentigrade");
        System.out.println("----------------------");
        for(int degreesInFahrenheit=0; degreesInFahrenheit<=20; degreesInFahrenheit++)
        {
            degreesInCentigrade = centigrade(degreesInFahrenheit);
            System.out.printf("%d\t\t\t%.2f\n", degreesInFahrenheit, degreesInCentigrade);
        }

    }


    /**
     * The method centigrade converts degrees in Fahrenheit
     * to degrees in Centigrade
     * @param fahrenheit Degrees in Fahrenheit
     * @return Degrees in Fahrenheit converted to degrees in Centigrade
     */
    public static float centigrade(int fahrenheit)
    {
        float degreesInCentigrade;

        degreesInCentigrade = (5/9.0F) * (fahrenheit - 32);

        return degreesInCentigrade;
    }
}
