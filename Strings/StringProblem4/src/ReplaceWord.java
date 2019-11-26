import java.util.*;

import static java.util.stream.Collectors.toList;

public class ReplaceWord {
    public static void main(String[] args) {
        System.out.println(wordSort("String sssmethod tesst sss", 3, "this"));
        System.out.println(wordSort("String sssmethod atesst ss", 2, "that"));
        System.out.println(wordSort("In this String all elements with length of 2 will be replaced by " +
                "DOOM", 2, "DOOM"));
    }

    private static List<String> wordSort(String s, int wordLength, String toReplace){
        return Arrays.stream(s.split("\\W+"))
                .map(x -> x.length()==wordLength ? toReplace : x)
               .collect(toList());
    }
}

