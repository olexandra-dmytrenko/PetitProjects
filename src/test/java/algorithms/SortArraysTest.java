package algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
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
        LinkedList<Integer> sortedList = SortArrays.sortByInsertions(initialList);

        List<Integer> expectedList = Arrays.asList(2, 3, 4, 5, 7, 8);
        assertEquals(expectedList, sortedList);
    }

    @Test
    public void isertionSortForFrontInsertion() throws Exception {
        LinkedList<Integer> initialList = new LinkedList<>();
        initialList.add(3);
        initialList.add(6);
        initialList.add(2);
        initialList.add(5);
        LinkedList<Integer> sortedList = SortArrays.sortByInsertions(initialList);

        List<Integer> expectedList = Arrays.asList(2, 3, 5, 6);
        assertEquals(expectedList, sortedList);
    }

    @Test
    public void quckSort(){
        int [] a = {1, 2, 9, 5, 8, 7, 1, 4, 0};
        //base = 8
        //(1, 2, 0, 5, 4, 1, 7, 8, 9)
        int [] act = (new Quicksort()).sort(a);
//        int [] act = (new SortArrays()).quickSort(a);
//        int [] exp = {1, 2, 0, 5, 4, 7, 1, 8, 9}; - after first iteration
        int [] exp = {0, 1, 1, 2, 4, 5, 7, 8, 9};
        assertArrayEquals(exp, act);
    }

    @Test
    public void nykytaInsert() {
        NykytaSortNumbers n = new NykytaSortNumbers();
        n.insertSortAndPrint();
    }
}