package lazy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Oleksandra_Dmytrenko on 11/24/2015.
 */
public class RunLazy {
 /*   public static void main(String[] args) {
        //RunLazy runLazy = new RunLazy(new Lazy<Long>( new Long("10")));
        final List names = new ArrayList();
        names.add( "David");
        names.add( "Sam");
        names.add( "Ben");

printNames(() -> 10);
//        names.stream().forEach(x -> {
//            printNames(() -> get());
//        });

    }
*/
    static void printNames(Supplier arg) {
        System.out.println(arg.get());
    }

    static void display(Supplier<Integer> arg) {
        System.out.println(arg.get());
    }

    public static void main(String[] args) {

        // Pass lambdas to the display method.
        // ... These conform to the Supplier class.
        // ... Each returns an Integer.
        display(() -> 10);
        display(() -> 100);
        display(() -> (int) (Math.random() * 100));
    }


    private <T> RunLazy(Lazy<T> mapper){

    }
    private static <R> R use(final Supplier<R> mapper) {
        return mapper.get();
    }
}
