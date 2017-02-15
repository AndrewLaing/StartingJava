import java.util.Iterator;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */
public class Card
{
    private String[] validValues = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
                                    "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

    private String[] validSuits = {"DIAMONDS", "HEARTS", "SPADES", "CLUBS"};


    private String value;
    private String suit;

    public Card(String value, String suit)
    {
        if(isValidValue(value) && isValidSuit(suit))
        {
            this.value = value;
            this.suit = suit;
        }
    }


    private boolean isValidValue(String value)
    {
        for(String validValue : validValues)
        {
            if(value.equals(validValue))
                return true;
        }
        return false;
    }


    private boolean isValidSuit(String suit)
    {
        for(String validSuit : validSuits)
        {
            if(suit.equals(validSuit))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        String card = value + suit;
        return card.hashCode();
    }

    public boolean equals(Card obj)
    {
        return value.equals(obj.value) && suit.equals(obj.suit);
    }

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }
}
