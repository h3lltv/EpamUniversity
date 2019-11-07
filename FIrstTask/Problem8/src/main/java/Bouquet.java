import java.util.ArrayList;
import java.util.Collections;

public class Bouquet {
    public ArrayList<Flower> bouquet = new ArrayList<>();

    public void addFlower(Flower flower) {
        bouquet.add(flower);
    }

    public void deleteFlower() {
        bouquet.remove(Collections.min(bouquet));
    }

    public int getCost() {
        int cost = 0;
        for (Flower f : bouquet) {
            cost += f.getPrice();
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
