import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(wordSort("String sssmethod tesst"));
        System.out.println(wordSort("String sssmethod atesst"));
        System.out.println(wordSort("112 22 333  4444 55555"));
        System.out.println(wordSort("112 22 333  4444 55555 "));
        System.out.println(wordSort("aaa AAaaAAaAAa abdabsda AAAAAAAAAAAAAA"));
        System.out.println(wordSort("aaa AAaaAAaAAa abdabsda AAAAAAAAAAAAAAaaa"));
    }

    private static String wordSort(String s){
        String word="";
        try {
            word = Arrays.stream(s.split("\\W+"))
                    .filter(LongestPalindrome::isPalindrome)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .collect(Collectors.toList())
                    .get(0);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("No palindromes in text!");
        }
        return word;
    }

    private static boolean isPalindrome(String text) {
        String temp  = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }

}
