
import java.time.LocalDate;

//import java.time.LocalDateTime;

public class Wine {
    private String name;
    private String country;
    private  LocalDate date;

    private Wine(String n, String c, int year){
        name = n;
        country = c;
        date = LocalDate.of(year,10,12);
    }

    @Override
    public String toString() {
        return ("Sort: "+name + ", from "+country + ", "+ date.getYear() +" year harvest");
    }

    public static int getAge(Wine w){
        return LocalDate.now().minusYears(w.date.getYear()).getYear();
    }


    public static void main(String[] args) {
        WineCatalog wc = new WineCatalog();
        Wine w1 = new Wine("Wine1", "France", 1867);
        Wine w2 = new Wine("Wine2", "France", 1967);
        Wine w3 = new Wine("Wine3", "France", 1954);
        Wine w4 = new Wine("Wine4", "France", 1980);
        Wine w5 = new Wine("Wine5", "France", 1992);
        wc.addWine(w1);
        wc.addWine(w2);
        wc.addWine(w3);
        wc.addWine(w4);
        wc.addWine(w5);
        System.out.println(wc);
    }
}

