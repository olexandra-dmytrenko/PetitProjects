package algorithms;

import java.util.stream.IntStream;

/**
 * Created by olexandra on 8/22/17.
 */
public class SumArrayParts {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        final int sum = A[A.length - 1];
        return IntStream.of(A).map(i -> Math.abs(sum - 2 * i)).min().getAsInt();
// 66%
    }

    public static int solution2(int[] A) {
        int length = A.length;
        for (int i = 1; i < length; i++) {
            A[i] += A[i - 1];
        }
        final int sum = A[length - 1];
        return IntStream.of(A).map(i -> Math.abs(sum - 2 * i)).min().getAsInt();
        //86%
    }

    public static int solution3(int[] A) {
        int length = A.length;
        if (length == 2) {
            return A[1] - A[0];
        }
        for (int i = 1; i < length; i++) {
            A[i] += A[i - 1];
        }
        final int sum = A[length - 1];
        int min = Math.abs(sum - 2 * A[0]);
        for (int i = 1; i < length; i++) {
            int abs = Math.abs(sum - 2 * A[i]);
            if (min > abs) {
                min = abs;
            }
            if (min == 0) {
                break;
            }
        }
        return min;
        //91%
    }

    public static int solution4(int[] A) {
        int sum = IntStream.of(A).sum();
        int left = 0;
        int right = sum;
        int min = sum;
        for (int i : A) {
            left += i;
            right -= i;
            int abs = Math.abs(left - right);
            if (min > abs) {
                min = abs;
            }
        }
        return min;
        //33%
    }

    public static int solution5(int[] A) {
        int length = A.length;
        if (length == 2) {
            return A[1] - A[0];
        }
        for (int i = 1; i < length; i++) {
            A[i] += A[i - 1];
        }
        final int sum = A[length - 1];
        int min = Math.abs(sum - 2 * A[0]);
        for (int leftSum = 1; leftSum < length - 1; leftSum++) {
            int abs = Math.abs(sum - 2 * A[leftSum]);
            if (min > abs) {
                min = abs;
            }
            if (min == 0) {
                break;
            }
        }
        return min;
        //100%
    }
}
