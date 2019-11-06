import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Problem2 {
    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        long timeStart = System.currentTimeMillis();
        generatePalindrome();
        System.out.println(map.size());
        System.out.println(System.currentTimeMillis() - timeStart);
        writePalindrome(map);
        //System.out.println(map);

    }

    private static long createPalindrome(long input, int base, int isOdd) {
        long n = input;
        long palindrome = input;

        if (n > 0) {
            if (isOdd == 1) {
                n /= base;
            }

            while (n > 0) {
                palindrome = palindrome * base + (n % base);
                n /= base;
            }
        }

//        if (n < 0) {
//
//            int j = (int)input;
//            int pal = j;
//            while (j < 0) {
////                palindrome = ~palindrome;
//             //   pal = pal >> 16;
//              //  pal = Integer.rotateLeft(pal, 16);
//
//               // pal = pal >>> 8;
//                palindrome = (Integer.reverse(pal) * base + (j % base));
//                //n= n>>>8;
//                //n=~n;
//                j /= base;
//              //  pal = Integer.rotateLeft(pal, 16);
//            }
//            System.out.println(palindrome);
//        }
        return palindrome;
    }

    private static void generatePalindrome() {
        long number;
        for (int j = 0; j < 2; j++) {
            int i = 1;
            while ((number = createPalindrome(i, 2, j % 2)) < Integer.MAX_VALUE) {
                i++;
                map.put((int) number, Integer.toBinaryString((int) number));
            }
        }
    }


    private static void writePalindrome(HashMap<Integer, String> hm) {
        hm.entrySet().forEach(entry -> {
            try (FileWriter writer = new FileWriter("mapResult.txt", true)) {
                writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
}


