package ifarraycanbesorted;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class ArrayToSortTestParametrized {

    private boolean canBeSortedExpected;
    private int arrInts[];

    public ArrayToSortTestParametrized(Boolean canBeSortedExpected, int[] arrInts) {
        this.canBeSortedExpected = canBeSortedExpected;
        this.arrInts = arrInts;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        Object[] params1 = new Object[]{Boolean.FALSE, new int[]{1, 3, 2}};
        Object[] params1 = new Object[]{Boolean.FALSE, new int[]{2, 1, 3}};
        Object[] params2 = new Object[]{Boolean.FALSE, new int[]{1, 3, 2, 2}};
        return Arrays.asList(new Object[][]{{params1}, {params2}});

    }

    @org.junit.Test
    public void testCanBeSorted() throws Exception {
        System.out.println(arrInts);
        System.out.println(canBeSortedExpected);
        ArrayToSort a = new ArrayToSort(arrInts);
        boolean canBeSortedActual = a.canBeSorted();
        Assert.assertEquals(canBeSortedExpected, canBeSortedActual);
    }
}