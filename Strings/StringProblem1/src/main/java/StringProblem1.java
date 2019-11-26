import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class StringProblem1 {

    private static Map<String, Long> countWords(String text) {
        return Arrays
                .stream(text.replaceAll("[-.?!)(,:]", "").split("\\s"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Map<String, Long> sortMap(Map<String, Long> map, ArrayList<String> list) {
        return map
                .entrySet()
                .stream()
                .filter(x -> !list.contains(x.getKey()))
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        ArrayList<String> keyWords = new ArrayList<>();
        keyWords.add("text");
        keyWords.add("test");
        keyWords.add("to");
        System.out.println(sortMap(countWords("Text to test method. text testing methOd. text method meTHod"), keyWords));
    }
}
