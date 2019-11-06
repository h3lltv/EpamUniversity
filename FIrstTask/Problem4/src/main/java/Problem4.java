import java.util.*;

public class Problem4 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 0, 0, 0, 8, 5, 567, 567};
        int[] b = {2, 5, 6, 7, 3, 2, 2, 2, 2, 1, 2, 2, 2, 2};
        ArrayList<Integer> matches = Problem4.findMatches(a, b);
        System.out.println(matches);
    }

    public static ArrayList<Integer> findMatches(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < a.length; ++i) {
            map.put(a[i], 0);
        }
        for (int i = 0; i < b.length; ++i) {
            if (map.get(b[i]) != null && map.get(b[i]) == 0) {
                map.put(b[i], 1);
                matches.add(b[i]);
            }
        }
        return matches;
    }
}