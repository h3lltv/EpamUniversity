import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class WordsSort {
    public static void main(String[] args) {
        System.out.println(wordSort("String sssmethod tesst", 'S'));
        System.out.println(wordSort("String sssmethod atesst", 'e'));
        System.out.println(wordSort("aaa AAaaAAaAAa abdabsda AAAAAAAAAAAAAA", 'a'));
    }

    private static List<String> wordSort(String s, char toFind){

        return Arrays.stream(s.split("\\W+"))
                .sorted(comparingInt((String word) -> charactersCounter(word, toFind)).reversed().thenComparing(naturalOrder()))
                .collect(toList());

    }

    private static int charactersCounter(String word, char toFind) {
        int counter = 0;
        for(char c : word.toLowerCase().toCharArray()){
            if (c==Character.toLowerCase(toFind)){
                counter++;
            }
        }
        return counter;
    }

}
