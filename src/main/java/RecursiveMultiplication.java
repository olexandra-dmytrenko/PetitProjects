/**
 * Created by olexandra on 6/14/17.
 */
public class RecursiveMultiplication {
    public static void main(String[] args) {
        int a = 3, b = 2;
        int result = 0;
        if (b != 0 && a != 0) {
            result = add(Math.abs(a), Math.abs(b));
        }
        String sign = (Math.signum(a) < 0 && Math.signum(b) > 0 || Math.signum(a) > 0 && Math.signum(b) < 0) ? "-" : "";
        System.out.println(a + " * " + b + " = " + sign + result);
    }

    private static int add(int a, int left) {
        if (left == 1) {
            return a;
        }
        return a + add(a, left - 1);
    }
}
