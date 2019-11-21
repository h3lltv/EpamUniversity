import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        DataBaseAccess dao = new DataBaseAccess();
        Wife w = new Wife();
        ArrayList<String> list = new ArrayList<>();
        list.add("Sony");
        list.add("Bread");
        list.add("Milk");
        list.add("Sharp");
        list.add("Shit");
        dao.readDataBase();
        dao.getAllGoods();
        dao.getAvailableGoods(list);
       // dao.getTotalCost(list);
        dao.close();
    }
}

