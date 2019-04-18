package algorithms;

/**
 * https://stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence
 */
public class Fibonachi {

    private static int counter = 0;

    public static int fibonachi(int n) {
        counter++;
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonachi(n - 1) + fibonachi(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonachi(9));
        System.out.println(counter);
        /*      8
                16
        5-15 3n 32
        6-25 3n+1 64
        7-41 6n-1 128
        8-67 8n+ 3
        9-109
        2^n - 2n
        109
         */
    }
}
