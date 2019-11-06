
public class Flower {
    String name;
    int price;
    int number;

    Flower(String n, int p, int num){
        this.name = n;
        this.price = p;
        this.number = num;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }
}
