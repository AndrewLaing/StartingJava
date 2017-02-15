/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */

import java.util.*;

public class CardPlayer
{
    List<Card> hand;


    public CardPlayer()
    {
        hand = new LinkedList<Card>();
    }

    public void getCard(Card cardDealt)
    {
        hand.add(cardDealt);
    }

    // useful method if player will be dealt more than one hand
    public void emptyHand()
    {
        hand.clear();
    }

    public void showCards()
    {
        for(Card c : hand)
            System.out.println(c);
    }
}
