public enum Value {
    ACE(11),
    KING(4),
    QUEEN(3),
    JACK(2),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    public final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
