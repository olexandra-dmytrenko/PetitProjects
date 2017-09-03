package algorithms.recursion;

/**
 * Created by olexandra on 8/29/17.
 */
public class FibonachiNumbers {
    public static void main(String[] args) {
        int n = 6;
        int result = fibonachi(n);
        System.out.println(result);
    }

    private static int fibonachi(int n) {
        //1, 1, 2, 3, 5, 8
        if (n > 2){
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
        return 1;
    }
}
