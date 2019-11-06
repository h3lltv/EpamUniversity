import java.util.ArrayList;
import java.util.Scanner;

public class Hand {
    private static int handId = 1;
    private int id;
    private ArrayList<Card> hand;

    Hand(Deck deck) {
        setHandId();
        hand = new ArrayList<>();
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
    }

    private void setHandId() {
        id = handId;
        ++handId;

    }

    private int getHandId() {
        return id;
    }

    protected int countHand() {
        int handValue = 0;
        for (Card i : hand) {
            handValue += i.getNumValue();
        }
        return handValue;
    }

    private void handInfo() {
        System.out.println("Player " + getHandId() + ". You have: " + countHand() + ", need one more card? (yes/no)");
    }

    void startGame(Deck deck) {
        Scanner input = new Scanner(System.in);
        boolean moreCards = false;
        String answer;

        while (!moreCards && deck.getDeckSize()>0) {
            handInfo();
            showHand();
            answer = input.next();
            if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("yes")) {
                addCard(deck);
            } else if (answer.toLowerCase().equals("n") || answer.toLowerCase().equals("no")) {
                moreCards = true;
            } else {
                System.out.println("Input error, please try again...");
            }
        }
    }

    private void addCard(Deck deck) {
        hand.add(deck.drawCard());
    }

    private void showHand() {
        System.out.print("Player " + getHandId() + " has: ");
        for (Card i : hand) {
            System.out.print(i + "; ");
        }
        System.out.println();
    }

    static int compareHands(int first, int second) {
//        final int firstHand = first.countHand();
//        final int secondHand = second.countHand();
        if (first == second) {
            return 0;
        } else if (first > 21 && second <= 21) {
            return 2;
        } else if (first <= 21 && second > 21) {
            return 1;
        } else if ((first <= 21) && (first > second)) {
            return 1;
        }
        else if ((second <= 21) && (first < second)) {
            return 2;
        }
        else {
            return 0;
        }
    }

    static void getResult(int winnerHand) {
        if (winnerHand == 0) {
            System.out.println("Draw!");
        } else if (winnerHand == 1) {
            System.out.println("Player 1 win!");
        } else if (winnerHand == 2) {
            System.out.println("Player 2 win!");
        }
    }
}
