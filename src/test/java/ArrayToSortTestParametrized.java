import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ArrayToSortTestParametrized {

    private boolean canBeSortedExpected;
    private int arrInts[];

    public ArrayToSortTestParametrized(boolean canBeSortedExpected, int[] arrInts) {
        this.canBeSortedExpected = canBeSortedExpected;
        this.arrInts = arrInts;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        Object[][] objects = new Object[][]{
                {new int[]{1, 3, 2, 2}, true}
        };
        return objects;

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