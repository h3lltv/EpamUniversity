import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shop {
    static ArrayList<Flower> flowers = new ArrayList<>();

    private void addFlower(Flower flower) {
        flowers.add(flower);
    }

    private Bouquet createBouquet(int maxValue) {
        Bouquet bouquet = new Bouquet();
        while (bouquet.getCost() < maxValue) {
            for (Flower f : flowers) {
                if ((bouquet.getCost() + f.getPrice()) <= maxValue && f.getNumber() > 0) {
                    bouquet.addFlower(f);
                    f.decrementNumber();
                }
            }
        }
        int size = bouquet.getSize();
        if (size % 2 != 1) {
            bouquet.deleteFlower();
        }
        System.out.println(bouquet.getCost());
        System.out.println("size " + bouquet.getSize());
        return bouquet;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner sc = new Scanner(System.in);
        Flower flower1 = new Flower("Flower1", 1, 10);
        Flower flower2 = new Flower("Flower2", 2, 10);
        Flower flower3 = new Flower("Flower3", 3, 10);
        Flower flower4 = new Flower("Flower4", 4, 0);
        Flower flower5 = new Flower("Flower5", 5, 10);
        Flower flower6 = new Flower("Flower6", 6, 10);
        Flower flower7 = new Flower("Flower7", 7, 1);
        shop.addFlower(flower1);
        shop.addFlower(flower2);
        shop.addFlower(flower3);
        shop.addFlower(flower4);
        shop.addFlower(flower5);
        shop.addFlower(flower6);
        shop.addFlower(flower7);
        Collections.shuffle(flowers);
        //  System.out.println(flowers);
        Collections.sort(flowers);
        System.out.println("Enter bouquet price:");
        Bouquet bq = shop.createBouquet(sc.nextInt());
        System.out.println(bq + "\n " + "Bouquet cost: " + bq.getCost());
    }
}
