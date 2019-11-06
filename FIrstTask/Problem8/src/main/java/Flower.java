public class Flower {
    String name;
    int price;
    int number;

    Flower(String n, int p, int num){
        this.name = n;
        this.price = p;
        this.number = num;
    }

    @Override
    public String toString() {
        return name;
    }
}
