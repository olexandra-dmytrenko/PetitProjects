package algorithms;

import java.util.Arrays;

/**
 * Created by Oleksandra_Dmytrenko on 8/13/2017.
 */
public class CompareWithMaxes2 {
    public static int[] counts(int[] nums, int[] maxes){
        int length = maxes.length;
        int[] result = new int[length];
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int max = maxes[i];
            int binaryResult = Arrays.binarySearch(nums, max);
            result[i] = Math.abs(binaryResult + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 8, 7};
        int[] b = {3, 1, 7, 8, 0};
//        int[] a = {1, 5, 2, 8};
//        int[] b = {4, 0, 5, 9};
        int[] counts = counts(a, b);
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            System.out.println(count);
        }
    }
}
