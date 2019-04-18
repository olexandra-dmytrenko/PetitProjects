package ua.procamp.streams.stream;

import org.apache.commons.lang.ArrayUtils;
import ua.procamp.streams.function.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.lang.ArrayUtils.toObject;

public class AsIntStream implements IntStream {

    private static final String NO_VALUES_EXCEPTION_MSG = "The operation can be performed only if there are values.";

    private List<Integer> values;
    private ArrayDeque<Supplier<List<Integer>>> deque = new ArrayDeque<>();

    private AsIntStream() {
        this.values = new ArrayList<>();
    }

    private AsIntStream(int... values) {
        throwIfNull(values);
        this.values = convertType(values);
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        return (double) sum() / getFinalList().size();
    }

    @Override
    public Integer max() {
        return Collections.max(getFinalListIfNotEmpty());
    }

    @Override
    public Integer min() {
        return Collections.min(getFinalListIfNotEmpty());
    }

    @Override
    public long count() {
        return getFinalList().size();
    }

    @Override
    public Integer sum() {
        throwIfEmpty();
        int sum = 0;
        for (int value : getFinalList()) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int[] toArray() {
        return ArrayUtils.toPrimitive(values.toArray(new Integer[]{}));
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        Supplier<List<Integer>> valuesSupplied = () -> {
            values.removeIf(i -> !predicate.test(i));
            return values;
        };
        deque.add(valuesSupplied);
        return this;
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        Supplier<List<Integer>> valuesSupplied = () -> {
            for (int i = 0; i < values.size(); i++) {
                values.set(i, mapper.apply(values.get(i)));
            }
            return values;
        };
        deque.add(valuesSupplied);
        return this;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        Supplier<List<Integer>> valuesSupplied = () -> {
            int size = values.size();
            for (int i = 0; i < size; i++) {
                final int[] newVals = func.applyAsIntStream(values.get(0)).toArray();
                final Integer remove = values.remove(0);
                values.addAll(convertType(newVals));
            }
            return values;
        };
        deque.add(valuesSupplied);
        return this;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int result = identity;
        for (Integer value : getFinalList()) {
            result = op.apply(result, value);
        }
        return result;
    }

    @Override
    public void forEach(IntConsumer action) {
        for (Integer value : values) {
            action.accept(value);
        }
    }

    private List<Integer> getFinalListIfNotEmpty() {
        getFinalList();
        throwIfEmpty();
        return values;
    }

    private List<Integer> getFinalList() {
        for (Supplier<List<Integer>> aDeque : deque) {
            aDeque.get();
        }
        return values;
    }

    private void throwIfEmpty() {
        if (isEmpty(this.values)) {
            throw new IllegalArgumentException(NO_VALUES_EXCEPTION_MSG);
        }
    }

    private void throwIfNull(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException(NO_VALUES_EXCEPTION_MSG);
        }
    }

    private ArrayList<Integer> convertType(int[] values) {
        return new ArrayList<>(asList(toObject(values)));
    }
}
