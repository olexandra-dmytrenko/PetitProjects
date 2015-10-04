import java.util.Arrays;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
        Object[] params1 = new Object[] {Boolean.TRUE, new int[] { 1, 3, 2, 2 } };
        return Arrays.asList(new Object[][] { params1 });

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