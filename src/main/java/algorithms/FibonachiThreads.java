package algorithms;

import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * https://stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence
 */
public class FibonachiThreads {

    static ExecutorService executorService = Executors.newCachedThreadPool();
    private static int counter = 0;
    //Thread.

    public static int fibonachi(int n) throws ExecutionException, InterruptedException {
        counter++;
        Thread.sleep(5000);
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        Future<Integer> one = executorService.submit(() -> fibonachi(n - 1));
        Future<Integer> two = executorService.submit(() -> fibonachi(n - 2));
        return one.get() + two.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(fibonachi(6));
        System.out.println(counter);
        Stack stack = new Stack();
        //stack.
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
        executorService.shutdown();
    }
}
