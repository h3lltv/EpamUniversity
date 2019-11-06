public class Card {
    private  Suit suit;
    private Value value;
    Card (Suit s, Value v){
        suit = s;
        value = v;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public int getNumValue(){
        return value.getValue();
    }

    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
