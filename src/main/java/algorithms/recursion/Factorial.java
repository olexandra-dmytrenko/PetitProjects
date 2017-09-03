package algorithms.recursion;

/**
 * Created by olexandra on 8/29/17.
 */
public class Factorial {
    public static void main(String[] args) {
        int result = factorialRecursion(2);
        System.out.println(result);
    }

    private static int factorialRecursion(int n) {
        if (n > 1) {
            return n * factorialRecursion(n - 1);
        }
        return 1;
    }

    private static int factorialCycle(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
