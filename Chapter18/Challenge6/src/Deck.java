/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */

import java.util.*;

public class Deck
{
    List<Card> cards;

    private String[] validValues = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                                    "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    private String[] validSuits = {"DIAMONDS", "HEARTS", "SPADES", "CLUBS"};

    private Iterator<Card> it;


    public Deck()
    {
        cards  = new LinkedList<Card>();
        makeDeck();     // add 52 cards
        shuffleDeck();  // shuffle the cards
    }

    private void makeDeck()
    {
        for(int i=0; i<validSuits.length; i++)
        {
            for(int j=0; j<validValues.length; j++)
            {
                cards.add(new Card(validValues[j], validSuits[i] ));
            }
        }

        it = cards.listIterator();
    }

    private void shuffleDeck()
    {
        Collections.shuffle(cards);
    }

    // verify deck contents
    public void printDeck()
    {
        for(Card c : cards)
            System.out.println(c);
    }

    // verify cards remaining
    public int cardsRemaining()
    {
        return cards.size();
    }


    // useful method if implementing a real game
    public void resetDeck()
    {
        cards.clear();  // empty the Linked List
        makeDeck();     // add 52 cards
        shuffleDeck();  // shuffle the cards

    }

    // return a card and remove it from the deck
    public Card dealCard()
    {
        if(it.hasNext()) {
            Card dealt = it.next();
            it.remove();
            return dealt;
        }
        return null;
    }
}
