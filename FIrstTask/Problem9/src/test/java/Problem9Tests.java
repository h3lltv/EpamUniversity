import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem9Tests {

    @Test
    public void deckTest(){
        Deck deck = new Deck();
        Assertions.assertEquals(deck.getDeckSize(), 36);
    }

    @Test
    public void drawCardTest(){
        Deck deck = new Deck();
        int cardsToDraw = 30;
        int finalSize = deck.getDeckSize()-cardsToDraw;
        for (int i = 0; i < cardsToDraw; i++) {
            deck.drawCard();
        }
        Assertions.assertEquals(deck.getDeckSize(), finalSize);
    }

    @Test
    public void compareHandsTest(){
        Assertions.assertEquals(2, Hand.compareHands(13,19));
        Assertions.assertEquals(2, Hand.compareHands(190,0));
        Assertions.assertEquals(2, Hand.compareHands(25,19));
        Assertions.assertEquals(0, Hand.compareHands(25,25));
        Assertions.assertEquals(0, Hand.compareHands(20,20));
        Assertions.assertEquals(1, Hand.compareHands(21,20));
        Assertions.assertEquals(0, Hand.compareHands(21,21));
        Assertions.assertEquals(2, Hand.compareHands(22,21));
        Assertions.assertEquals(1, Hand.compareHands(21,14));
    }
}
