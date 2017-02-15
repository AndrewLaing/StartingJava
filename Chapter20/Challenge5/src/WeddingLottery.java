/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/02/2017.
 */

import java.util.*;     // for List and LinkedList

public class WeddingLottery
{
    private int currentPosition = 0;
    private List<String> hopeful;
    private List<String> eliminated;
    private int[] steps;


    public WeddingLottery(List suitors, int[] steps)
    {
        this.hopeful = new LinkedList<String>(suitors);
        this.eliminated = new LinkedList<String>();

        // Copy the steps array to this.steps
        int stepSize = steps.length;
        this.steps = new int[stepSize];
        for(int i = 0; i<stepSize; i++)
            this.steps[i] = steps[i];
    }


    /**
     * The method getEliminated returns a LinkedList containing the names of
     * the rejected suitors
     * @return A LinkedList containing the names of the rejected suitors
     */
    public List<String> getEliminated()
    {
        List<String> eliminatedSuitors = new LinkedList<String>(eliminated);
        return eliminatedSuitors;
    }


    /**
     * The method returnHopeful returns a LinkedList containing the names of
     * the suitors who have not been eliminated
     * @return A LinkedList containing the names of the suitors who have
     *         not been eliminated
     */
    public List<String> getHopeful()
    {
        List<String> hopefulSuitors = new LinkedList<String>(hopeful);
        return hopefulSuitors;
    }


    /**
     * The method rotate calculates and returns the index
     * of the suitor to be eliminated after rotating around the table
     * @param x
     * @return
     */
    private int rotate(int x)
    {
        return (x + currentPosition) % hopeful.size();
    }


    /**
     * The method eliminateSuitor calculates the position of the suitor
     * to eliminate, removes them from the hopeful list, adds them to
     * the eliminated list, and if necessary corrects currentPosition
     * @param x The number of steps to move clockwise around the table
     */
    private void eliminateSuitor(int x)
    {
        // Idiot check - the last suitor cannot escape from
        //               marrying the princess
        if(hopeful.size()==1)
            return;

        int n = rotate(x);
        eliminated.add(hopeful.remove(n));
        currentPosition = currentPosition % hopeful.size();
    }


    public void calculateGroom()
    {
        for(int step : steps)
            eliminateSuitor(step);
    }
}
