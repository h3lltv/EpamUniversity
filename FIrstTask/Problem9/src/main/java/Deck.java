import java.util.*;

public class Deck {
    private ArrayList<Card> deckList = new ArrayList<>();

    Deck() {
        EnumSet<Value> valueSet = EnumSet.allOf(Value.class);
        EnumSet<Suit> suitSet = EnumSet.allOf(Suit.class);
        for (Suit s : suitSet) {
            for (Value v : valueSet) {
                deckList.add(new Card(s, v));
            }
        }
        Collections.shuffle(deckList);
    }

    public Card drawCard() {
        Random rng = new Random();
        int index = rng.nextInt(deckList.size());
        Card drawnCard = deckList.get(index);
        deckList.remove(index);
        return drawnCard;
    }
    public int getDeckSize(){
        return deckList.size();
    }

//    public static void main(String[] args) {
//        Deck deck = new Deck();
//        System.out.println(deckList + " " + deckList.size());
//    }

//    int getDeckSize(){
//        return deckList.size();
//    }
}
