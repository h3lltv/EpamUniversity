import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Problem2 {
    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        long timeStart = System.currentTimeMillis();
        generateNegitivePalindrome();
        generatePalindrome();
        System.out.println(map.size());
        System.out.println(System.currentTimeMillis() - timeStart);
        //writePalindrome(map);
        System.out.println(System.currentTimeMillis() - timeStart);
        //System.out.println(map);
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

    public static int showInt(String bitNegativeNumber) {
        char[] charArr = bitNegativeNumber.toCharArray();
        //int count = 0;

        int k;
        for (k = 0; k < 32; ++k) {
            if (charArr[k] == '1') {
                charArr[k] = '0';
            } else {
                charArr[k] = '1';
            }
        }

        for (k = 31; charArr[k] == '1'; --k) {
            charArr[k] = '0';
        }

        charArr[k] = '1';
        String string = new String(charArr);
        //Integer.parseInt(string, 2);
        return -Integer.parseInt(string, 2);
    }

    private static void generateNegitivePalindrome() {
        char[] negativePolindromes = new char[16];
        String bitNegativeNumber;
        String halfBit;
        int result;
        negativePolindromes[0] = '1';

        for (int j = 1; j < 16; ++j) {
            negativePolindromes[j] = '0';
        }
        int k = 15;

        for (int i = 32767; i > 0; --i) {
            if (negativePolindromes[k] != '1') {
                negativePolindromes[k] = '1';
            } else {
                for (k = 15; negativePolindromes[k] == '1'; --k) {
                    negativePolindromes[k] = '0';
                }

                negativePolindromes[k] = '1';
            }

            halfBit = new String(negativePolindromes);
            bitNegativeNumber = halfBit + (new StringBuffer(halfBit)).reverse().toString();
            result = showInt(bitNegativeNumber);
            map.put(result, Integer.toBinaryString(result));
        }
        //System.out.println(bitNegativeNumber);
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


