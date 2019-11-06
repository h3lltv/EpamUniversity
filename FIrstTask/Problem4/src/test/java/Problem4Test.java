
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Problem4Test {

    @Test
    public void nullArrayTest(){
        int[] firstArray = null;
        int[] secondArray = {2, 5, 6, 7, 3, 2, 2, 2, 2, 1, 2, 2, 2, 2};
        Assertions.assertThrows(NullPointerException.class, () -> {
            Problem4.findMatches(firstArray, secondArray);
        });
    }

    @Test
    public void bothNulledArraysTest(){
        int[] firstArray = null;
        int[] secondArray = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            Problem4.findMatches(firstArray, secondArray);
        });
    }

    @Test
    public void positiveArrayTest(){
        int[] firstArray = {6, 3, 3};
        int[] secondArray = {2, 3, 6};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        Assertions.assertEquals(list, Problem4.findMatches(firstArray, secondArray));
    }

    @Test
    public void negativeArrayTest(){
        int[] firstArray = {-6, 3, -3};
        int[] secondArray = {-2, 3, -6};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-6);
        Assertions.assertEquals(list, Problem4.findMatches(firstArray, secondArray));
    }
}
