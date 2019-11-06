import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    public void charTest(){
        Assertions.assertEquals('a', Problem6.findCommonSymbol("aaaax4" +
                "bbbx3" +
                "cccx3" +
                "dd"));
    }
    public void punctuationMarkTest(){
        Assertions.assertEquals('a', Problem6.findCommonSymbol("aaaax4tes,,,,,,,,,,,,,,ttest"));
        Assertions.assertEquals('a', Problem6.findCommonSymbol(",,,.Test, string, with, punctuation, marks."));
    }

    public void upperCaseTest(){
        Assertions.assertNotEquals('Z', Problem6.findCommonSymbol("zzz"));
        Assertions.assertNotEquals('S', Problem6.findCommonSymbol("In this string the most common symbol is"));
        Assertions.assertEquals('s', Problem6.findCommonSymbol("In this string the most common symbol is"));
    }
}
