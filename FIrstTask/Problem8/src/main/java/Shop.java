import java.util.ArrayList;
import java.util.Collections;

public class Shop {
    static ArrayList<Flower> flowers = new ArrayList<>();

    private void addFlower(Flower flower) {
        flowers.add(flower);
    }

    private Bouquet createBouquet(int maxValue) {
        Bouquet bouquet = new Bouquet();

        while (bouquet.getCost() < maxValue) {
            for (Flower f : flowers) {
                if ((bouquet.getCost() + f.getPrice()) <= maxValue && f.getNumber() > 0 && bouquet.getSize() + 1 % 2 > 0) {
                    bouquet.addFlower(f);
                    f.number--;
                }
            }
        }
        while (bouquet.getCost() > maxValue) {
            bouquet.deleteFlower();
        }
        System.out.println(bouquet.getCost());
        return bouquet;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Flower flower1 = new Flower("Flower1", 1, 10);
        Flower flower2 = new Flower("Flower2", 2, 10);
        Flower flower3 = new Flower("Flower3", 3, 10);
        Flower flower4 = new Flower("Flower4", 4, 0);
        Flower flower5 = new Flower("Flower5", 5, 10);
        Flower flower6 = new Flower("Flower6", 6, 10);
        Flower flower7 = new Flower("Flower7", 7, 10);
        shop.addFlower(flower1);
        shop.addFlower(flower2);
        shop.addFlower(flower3);
        shop.addFlower(flower4);
        shop.addFlower(flower5);
        shop.addFlower(flower6);
        shop.addFlower(flower7);
        Collections.shuffle(flowers);
        Bouquet bq = shop.createBouquet(21);
        System.out.println(bq + " " + bq.getCost());
    }
}
