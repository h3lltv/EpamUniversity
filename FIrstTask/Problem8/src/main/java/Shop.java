import java.util.ArrayList;

public class Shop {
    ArrayList<Flower> flowers = new ArrayList<>();

    void addFlower(Flower flower){
        flowers.add(flower);
    }

    public ArrayList<Flower> createBouquet (int maxValue){
        int cost = 0;
            while (cost<maxValue-1){
                for (Flower f : flowers){
                    if((maxValue-f.price)%7<=2){
                        Bouquet.addFlower(f);
                        f.number--;
                        cost += f.price;
                    }
            }
        }
        return Bouquet.bouquet;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Flower flower1 = new Flower("Flower1", 2, 10);
        Flower flower2 = new Flower("Flower2", 1, 10);
        Flower flower3 = new Flower("Flower3", 3, 10);
        Flower flower4 = new Flower("Flower4", 4, 10);
        Flower flower5 = new Flower("Flower5", 5, 10);
        Flower flower6 = new Flower("Flower5", 6, 10);
        Flower flower7 = new Flower("Flower5", 7, 10);
        shop.addFlower(flower1);
        shop.addFlower(flower2);
        shop.addFlower(flower3);
        shop.addFlower(flower4);
        shop.addFlower(flower5);
        System.out.println(shop.createBouquet(24)+" "+ Bouquet.getCost())
        ;
    }
}
