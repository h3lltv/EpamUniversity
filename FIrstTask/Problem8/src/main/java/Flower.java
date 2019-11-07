
public class Flower implements Comparable<Flower> {
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

    public int decrementNumber () {
        return number--;
    }

    public int getPrice() {
        return price;
    }
    @Override
    public int compareTo(Flower f){
        return (this.price - f.price);
    }
}
