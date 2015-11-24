package lazy;

import java.util.function.Supplier;

/**
 * Created by Oleksandra_Dmytrenko on 11/24/2015.
 */
public class Lazy<T> implements Supplier<T>{
    private final Supplier<T> supplier;
    private volatile T value;

    public Lazy(final Supplier<T> supplier) {
        this.supplier = supplier;
    }
    public T get() {
        return this.value;
    }
}
