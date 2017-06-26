package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by olexandra on 6/25/17.
 */
public class SortArrays {
    private static int allIterations = 0;

    public static List<Integer> bubbleSort(List<Integer> list) {
        for (int j = 0; j < list.size() - 1; j++) {
            System.out.println("General iteration number " + j);
            flipElements(list);
        }
        return list;
    }

    private static void flipElements(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(++allIterations + " Local iteration");
            if (list.get(i) > list.get(i + 1)) {
                int temp = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, temp);
            }
        }
    }

    public static LinkedList<Integer> sortByInsertions(LinkedList<Integer> list) {
        int iterationNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            System.out.println("Take next number " + list.get(i) + " to place it in the right place.");
            for (int j = 0; j < i; j++) {
                System.out.println(++iterationNumber + " Amount of sorted elements:  " + (i - 1));
                if (list.get(i) < list.get(j)) {
                    list.add(j, list.get(i));
                    list.remove(i + 1);
                    break;
                }
            }
        }
        return list;
    }
}
