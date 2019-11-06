import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem6 {
    public static char findCommonSymbol(String s) {
        Map<Character, Long> charMap = s.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return charMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .get();
    }

    public static void main(String[] args) {
        System.out.println(findCommonSymbol("sssaabbbb"));
        System.out.println(findCommonSymbol("String to Test Method SS tTTTTTTTTTTTTTTTTT "));
        System.out.println(findCommonSymbol("In this string the most common symbol is"));
    }
}
