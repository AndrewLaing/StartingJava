/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/02/2017.
 */

import java.util.*;
import java.util.Random;

public class Challenge5
{
    public static int getRandomNumber()
    {
        Random rn = new Random();
        return rn.nextInt(100);
    }


    public static void main(String[] args)
    {
        // Create the list of suitors
        List<String> suitors = new LinkedList<String>();
        suitors.add("Joe Dorsey");
        suitors.add("Mike Dubrovnik");
        suitors.add("Percival Primrose");
        suitors.add("Sean Lanagan");
        suitors.add("Sean Kelly");
        suitors.add("Liam Gonzalez");
        suitors.add("Pedro Aldomovar");
        suitors.add("Alfred Hitchcock");
        suitors.add("Julian Clarey");
        suitors.add("Micho Russell");

        // Create a list of suitors.size - 1 steps to move around the table
        int steps[] = new int[suitors.size()];
        for(int i=0; i<suitors.size(); i++)
            steps[i] = getRandomNumber();

        WeddingLottery winAPrincess = new WeddingLottery(suitors, steps);
        winAPrincess.calculateGroom();

        List<String> eliminated = winAPrincess.getEliminated();
        List<String> hopeful = winAPrincess.getHopeful();

        // Display the eliminated suitors first
        System.out.println("--- First the suitors eliminated! (in order of elimination) ----");
        for(int i=0; i<eliminated.size(); i++)
            System.out.println(eliminated.get(i));

        System.out.println("--- And the lucky man is.... ----");
        for(int i=0; i<hopeful.size(); i++)
            System.out.println(hopeful.get(i));
    }
}
