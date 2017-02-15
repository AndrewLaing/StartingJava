/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */
public class Challenge6
{
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        CardPlayer player1 = new CardPlayer();

        System.out.println("Size of deck before = " + newDeck.cardsRemaining());
        System.out.println("---------------------------");

        for(int i=0; i<5; i++)
            player1.getCard(newDeck.dealCard());

        player1.showCards();

        System.out.println("---------------------------");
        System.out.println("Size of deck after = " + newDeck.cardsRemaining());
    }
}
