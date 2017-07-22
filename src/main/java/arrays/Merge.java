package arrays;

import java.util.stream.Stream;

/**
 * Created by Oleksandra_Dmytrenko on 7/22/2017.
 Дано 2 массива в порядке возрастания. Надо их смерджить в один.
 */
public class Merge {
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {0};
        int[] ints = mergeArrays(a, b);
        Stream.of(ints).forEach(System.out::println);
    }

    private static int[] mergeArrays(int[] a, int[] b) {
        int size = a.length;
        int[] merged = new int[2 * size];
        int i = 0;
        int j = 0;
        int k = 0;
        int[] less;
        int[] more;

        // Determine which array starts from smaller numbers, and take it as the first one to copy numbers from
        if (a[0] <= b[0]) {
            less = a;
            more = b;
        } else {
            less = b;
            more = a;
        }

        do {
            int max;
            if (j < size) {
                max = more[j];
            } else {
                max = 1000000000;
            }
            while (i < size && less[i] <= max) {
                merged[k] = less[i];
                i++;
                k++;
            }
            // Flip array and indexes
            if (i <= size && j < size) {
                int[] switchArrays = more;
                more = less;
                less = switchArrays;
                int switchIndexes = j;
                j = i;
                i = switchIndexes;
            }
        }
        while (k < 2 * size);
        return merged;
    }
}
