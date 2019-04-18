package ua.procamp.streams.stream;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AsIntStreamTest {
    private int testVar = 0;

    @Test
    public void shouldCount2_whenOf2Elements() {
        IntStream stream = AsIntStream.of(1, 2);
        Assert.assertEquals(2, stream.count());
    }

    @Test
    public void shouldCount0_whenOf0Elements() {
        IntStream stream = AsIntStream.of();
        assertEquals(0, stream.count());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenOfNullElements() {
        AsIntStream.of(null);
    }

    @Test
    public void shouldFindAverage_when2El() {
        IntStream stream = AsIntStream.of(1, 2);
        assertEquals(1.5, stream.average(), 0.00000001);
    }

    @Test
    public void shouldFIndAverage_when1El() {
        IntStream stream = AsIntStream.of(2);
        assertEquals(2.0, stream.average(), 0.00000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenAverageOfEmpty() {
        IntStream stream = AsIntStream.of();
        stream.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenAverageOfNull() {
        IntStream stream = AsIntStream.of(null);
        stream.average();
    }

    @Test
    public void shouldFindMax_when2El() {
        IntStream stream = AsIntStream.of(1, -2);
        assertEquals((Integer) 1, stream.max());
    }

    @Test
    public void shouldFindMax_when2SameMinVals() {
        IntStream stream = AsIntStream.of(MIN_VALUE, MIN_VALUE);
        assertEquals((Integer) MIN_VALUE, stream.max());
    }

    @Test
    public void shouldFindMax_when1El() {
        IntStream stream = AsIntStream.of(-243);
        assertEquals(Integer.valueOf(-243), stream.max());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenMaxOfEmpty() {
        IntStream stream = AsIntStream.of();
        stream.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenMaxOfNull() {
        IntStream stream = AsIntStream.of(null);
        stream.max();
    }

    @Test
    public void shouldFindMin_when2El() {
        IntStream stream = AsIntStream.of(1, 2);
        assertEquals((Integer) 1, stream.min());
    }

    @Test
    public void shouldFindMin_when2SameMaxVals() {
        IntStream stream = AsIntStream.of(MAX_VALUE, MAX_VALUE);
        assertEquals((Integer) MAX_VALUE, stream.min());
    }

    @Test
    public void shouldFindMIN_when1El() {
        IntStream stream = AsIntStream.of(-243);
        assertEquals(Integer.valueOf(-243), stream.min());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenMinOfEmpty() {
        IntStream stream = AsIntStream.of();
        stream.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenMinOfNull() {
        IntStream stream = AsIntStream.of(null);
        stream.min();
    }

    @Test
    public void shouldCountSum_when1El() {
        IntStream stream = AsIntStream.of(-243);
        assertEquals(Integer.valueOf(-243), stream.sum());
    }

    @Test
    public void shouldCountSum_when2MaxEl() {
        IntStream stream = AsIntStream.of(MAX_VALUE, MAX_VALUE);
        assertEquals(Integer.valueOf(-2), stream.sum());
    }

    @Test
    public void shouldCountSum_when3El() {
        IntStream stream = AsIntStream.of(MAX_VALUE, MIN_VALUE, 1);
        assertEquals(Integer.valueOf(0), stream.sum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenSum0El() {
        IntStream stream = AsIntStream.of();
        stream.sum();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenSumNullEl() {
        IntStream stream = AsIntStream.of(null);
        stream.sum();
    }

    @Test
    public void shouldFilter_whenThereAreValidValues() {
        IntStream stream = AsIntStream.of(1, 2, 4, 3, 5);
        IntStream filtered = stream.filter(value -> value % 2 == 0);
        int max = filtered.max();
        assertEquals(4, max);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenFilterAllValuesWithMin() {
        IntStream stream = AsIntStream.of(1, 2, 4, 0);
        IntStream filtered = stream.filter(value -> value < 0);
        int max = filtered.min();
    }

    @Test
    public void shouldReturn0_whenFilterAllValuesWithCount() {
        IntStream stream = AsIntStream.of(1, 2, 4, 0);
        IntStream filtered = stream.filter(value -> value < 0);
        assertEquals(0, filtered.count());
    }

    @Test
    public void shouldReturn0_whenFilterNoValuesWithCount() {
        IntStream stream = AsIntStream.of();
        IntStream filtered = stream.filter(value -> value < 0);
        assertEquals(0, filtered.count());
    }

    @Test
    public void shouldMapAndAverage_whenAllValid() {
        IntStream stream = AsIntStream.of(4, 5);
        IntStream filtered = stream.map(value -> value * 2);
        double result = filtered.average();
        assertEquals(9, result, 0.00000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenMapAndAverageWithNoVals() {
        IntStream stream = AsIntStream.of();
        IntStream filtered = stream.map(value -> value * 2);
        filtered.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenMapAndAverageWithNullVals() {
        IntStream stream = AsIntStream.of(null);
        IntStream filtered = stream.map(value -> value * 2);
        filtered.count();
    }

    @Test
    public void shouldFilterAndMapAndSum_whenAllValid() {
        IntStream stream = AsIntStream.of(1, 2, 4, 3, 5);
        IntStream filtered = stream
                .filter(value -> value % 2 == 0)
                .map(value -> value * 2);
        int sum = filtered.sum();
        assertEquals(12, sum);
    }

    @Test
    public void shouldFlatMap_whenFunctionToExpand() {
        IntStream stream = AsIntStream.of(1, 2);
        IntStream resultStream = stream
                .flatMap(value -> AsIntStream.of(value, value));
        long result = resultStream.count();
        assertEquals(4, result);
    }

    @Test
    public void shouldFlatMap_whenFunctionToStaySame() {
        IntStream stream = AsIntStream.of(1, 2);
        IntStream resultStream = stream
                .flatMap(value -> AsIntStream.of(value));
        long result = resultStream.count();
        assertEquals(2, result);
    }

    @Test
    public void shouldFlatMap_whenFunctionToCollapses() {
        IntStream stream = AsIntStream.of(1, 2);
        IntStream resultStream = stream
                .flatMap(value -> AsIntStream.of());
        long result = resultStream.count();
        assertEquals(0, result);
    }

    @Test
    public void shouldFlatMap_whenInitialEmptyStream() {
        IntStream stream = AsIntStream.of();
        IntStream resultStream = stream
                .flatMap(value -> AsIntStream.of(value));
        long result = resultStream.count();
        assertEquals(0, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenFlatMapToNull() {
        IntStream stream = AsIntStream.of(1, 2);
        IntStream resultStream = stream
                .flatMap(value -> AsIntStream.of(null));
        resultStream.count();
    }

    @Test
    public void shouldReduce_whenSubtractSeveral() {
        IntStream stream = AsIntStream.of(1, 2, 3);
        int result = stream
                .reduce(1, (a, b) -> a - b);
        assertEquals(-5, result);
    }

    @Test
    public void shouldReduce_whenSubtractNoValues() {
        IntStream stream = AsIntStream.of();
        int result = stream
                .reduce(1, (a, b) -> a - b);
        assertEquals(1, result);
    }

    @Test
    public void shouldNotChangeArray_whenForEachWithNoValues() {
        IntStream stream = AsIntStream.of();
        stream.forEach(this::meantToTestForEach);
        assertEquals(0, testVar);
        assertArrayEquals(new int[]{}, stream.toArray());
        //tear down
        testVar = 0;
    }

    @Test
    public void shouldNotChangeArray_whenForEachWithValues() {
        IntStream stream = AsIntStream.of(1, 2);
        stream.forEach(this::meantToTestForEach);
        assertEquals(3, testVar);
        assertArrayEquals(new int[]{1, 2}, stream.toArray());
        //tear down
        testVar = 0;
    }

    private void meantToTestForEach(int a){
        testVar += a;
    }

    @Test
    public void shouldConvertToArray_when1El() {
        IntStream stream = AsIntStream.of(2);
        assertArrayEquals(new int[]{2}, stream.toArray());
    }

    @Test
    public void shouldConvertToArray_whenManyEl() {
        IntStream stream = AsIntStream.of(MIN_VALUE, MAX_VALUE, 0, -243, 8);
        assertArrayEquals(new int[]{MIN_VALUE, MAX_VALUE, 0, -243, 8}, stream.toArray());
    }

    @Test
    public void shouldConvertToArray_when0El() {
        IntStream stream = AsIntStream.of();
        assertArrayEquals(new int[]{}, stream.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrow_whenToArrayNullEl() {
        IntStream stream = AsIntStream.of(null);
        stream.toArray();
    }
}