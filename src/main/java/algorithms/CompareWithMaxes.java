package algorithms;

/**
 * Created by Oleksandra_Dmytrenko on 8/13/2017.
 */
public class CompareWithMaxes {
    public static int[] counts(int[] nums, int[] maxes){
        int length = maxes.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int max = maxes[i];
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if (num <= max){
                    counter++;
                }
            }
            result[i] = counter;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2};
        int[] b = {3, 1, 7, 8};
//        int[] a = {1, 5, 2, 8};
//        int[] b = {4, 0, 5, 9};
        int[] counts = counts(a, b);
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            System.out.println(count);
        }
    }
}
