import java.util.ArrayList;

public class Bouquet {
    public ArrayList<Flower> bouquet = new ArrayList<>();

    public void addFlower(Flower flower) {
        bouquet.add(flower);
    }

    public void deleteFlower() {
        bouquet.remove(bouquet.size()-1);
    }

    public double getCost() {
        int cost = 0;
        for (Flower f : bouquet) {
            cost += f.price;
        }
        return cost;
    }

    public int getSize(){
        return bouquet.size();
    }

    @Override
    public String toString() {
        return bouquet.toString();
    }
}
