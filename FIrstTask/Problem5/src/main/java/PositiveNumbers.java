import java.util.ArrayList;

public class PositiveNumbers {

    private static ArrayList<ArrayList<Integer>> positiveList = new ArrayList<>();

    private static void removeNegativeNumbers(int[][] a) {
        for (int[] arr : a) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int b : arr) {
                if (b > 0) {
                    list.add(b);
                }
            }
            positiveList.add(list);
        }
    }

    private static ArrayList<Integer> getMaxString(ArrayList<ArrayList<Integer>> lists) {
        int index = 0;
        double count = 0;
        double avg=0;
        for (ArrayList<Integer> a : lists) {
            for (int b : a) {
                count += b;
            }
            if (count / a.size() > avg) {
                avg = count / a.size();
                index = lists.indexOf(a);
            }
        }
        return lists.get(index);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, -5, -6, -13}, {666,-3, -4, 5, -6, -7},{5000,-5000, 666}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {-1, 2, 5, 6, -128, -666}};
        removeNegativeNumbers(arr);
        System.out.println(positiveList);
        System.out.println(getMaxString(positiveList));
    }
}
