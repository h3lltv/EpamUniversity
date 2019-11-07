import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Problem2 {
    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        generateNegativePalindrome();
        generatePalindrome();
        System.out.println(map.size());
        System.out.println("map filled in " + (System.currentTimeMillis() - timeStart) + " msec");
        writePalindrome(map);
        System.out.println("written in " + (System.currentTimeMillis() - timeStart) / 1000 + " sec");
        // System.out.println(map);
    }

    private static long createPalindrome(long input, int base, int isOdd) {
        long n = input;
        long palindrome = input;

        if (isOdd == 1) {
            n /= base;
        }

        while (n > 0) {
            palindrome = palindrome * base + (n % base);
            n /= base;
        }
        return palindrome;
    }

    private static void generateNegativePalindrome() {
        boolean stop = false;
        char[] negativePalindrome = new char[16];
        String bitNegativeNumber;
        String halfBit;
        negativePalindrome[0] = '1';

        for (int j = 1; j < 16; ++j) {
            negativePalindrome[j] = '0';
        }
        int k = 15;
        while (!stop) {
            if (negativePalindrome[k] != '1') {
                negativePalindrome[k] = '1';
            } else {
                for (k = 15; negativePalindrome[k] == '1'; --k) {
                    negativePalindrome[k] = '0';
                }
                negativePalindrome[k] = '1';
            }
            halfBit = new String(negativePalindrome);
            bitNegativeNumber = halfBit + (new StringBuffer(halfBit)).reverse().toString();
            long a = Long.parseLong(bitNegativeNumber, 2);
            map.put((int) a, Integer.toBinaryString((int) a));
            if ((int) a == -1) stop = true;
        }
    }

    private static void generatePalindrome() {
        long number;
        for (int j = 0; j < 2; j++) {
            int i = 0;
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


