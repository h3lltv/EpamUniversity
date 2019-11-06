
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Problem3 {
    static int maxValue;

    public static int getBiggerOdd (int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if(a[i]%2 != 0){
                maxValue = a[i];
            }
        }
        return maxValue;
    }

    public static int[] fillArray (int length, int seed){
        int[] arr = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(seed);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] testArray = fillArray(15, 400);
        System.out.println(Arrays.toString(testArray));
        System.out.println("\n" + getBiggerOdd(testArray));
    }
}
