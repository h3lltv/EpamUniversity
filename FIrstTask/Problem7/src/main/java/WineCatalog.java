import java.util.ArrayList;

public class WineCatalog {
    public ArrayList<Wine> wineCatalog = new ArrayList<>();

    void addWine(Wine w){
        wineCatalog.add(w);
    }

    @Override
    public String toString() {
        return wineCatalog.toString();
    }
}