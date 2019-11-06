
public class StartGame {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Hand hand1 = new Hand(deck);
        Hand hand2 = new Hand(deck);

        hand1.startGame(deck);
        hand2.startGame(deck);

        Hand.getResult(Hand.compareHands(hand1.countHand(), hand2.countHand()));
    }
}
