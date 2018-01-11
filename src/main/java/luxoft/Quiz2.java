package luxoft;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by olexandra on 11/5/17.
 */
public class Quiz2 {

    int val =10;

    Quiz2(int i ){
        val = i;
    }

    private AtomicInteger value = new AtomicInteger(val);

    public static void main(String[] args) {
        Quiz2 q = new Quiz2(5);
        System.out.println(q.value); //10
        System.out.println(q.value.decrementAndGet()); //9
    }
}