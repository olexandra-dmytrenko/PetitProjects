package algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/25/17.
 */
public class SortArraysTest {
    @Test
    public void bubbleSort() throws Exception {
        List<Integer> initialList = Arrays.asList(4, 3, 7, 8, 5, 2);
        List<Integer> sortedList = SortArrays.bubbleSort(initialList);

        List<Integer> expectedList = Arrays.asList(2, 3, 4, 5, 7, 8);
//        List<Integer> expectedList = Arrays.asList(3, 4, 7, 5, 2, 8);
        assertEquals(expectedList, sortedList);
    }
    // 1 итерация (3, 4, 7, 5, 2, 8)
    // 2 итерация (3, 4, 5, 2, 7, 8)
    // 3 итерация (3, 4, 2, 5, 7, 8)
    // 4 итерация (3, 2, 4, 5, 7, 8)
    // 5 итерация (2, 3, 4, 5, 7, 8)

    @Test
    public void bubbleSortWithDublicatesFull() throws Exception {
        List<Integer> initialList = Arrays.asList(20, 20, 4, 3, 7, 8, 5, 2, -3, 0, 5, -90);
        List<Integer> sortedList = SortArrays.bubbleSort(initialList);

        List<Integer> expectedList = Arrays.asList(-90, -3, 0, 2, 3, 4, 5, 5, 7, 8, 20, 20);
//        List<Integer> expectedList = Arrays.asList(3, 4, 7, 5, 2, 8);
        assertEquals(expectedList, sortedList);
    }

    @Test
    public void isertionSort() throws Exception {
        LinkedList<Integer> initialList = new LinkedList<>();
        initialList.add(4);
        initialList.add(3);
        initialList.add(7);
        initialList.add(8);
        initialList.add(5);
        initialList.add(2);
        initialList.add(2);
        initialList.add(2);
        initialList.add(2);
        initialList.add(2);
        LinkedList<Integer> sortedList = SortArrays.sortByInsertions(initialList);

        List<Integer> expectedList = Arrays.asList(2, 3, 4, 5, 7, 8);
        assertEquals(expectedList, sortedList);
    }

    @Test
    public void nykytaInsert() {
        NykytaSortNumbers n = new NykytaSortNumbers();
        n.insertSortAndPrint();
    }
}