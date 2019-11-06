import java.util.ArrayList;

public class Bouquet {
    public static ArrayList<Flower> bouquet = new ArrayList<>();

    public static void addFlower(Flower flower){
        bouquet.add(flower);
    }

    public static double getCost(){
        int cost=0;
        for (Flower f : bouquet){
            cost+=f.price;
        }
        return cost;
    }
}
