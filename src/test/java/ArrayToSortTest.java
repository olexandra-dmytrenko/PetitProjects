import org.junit.Assert;

public class ArrayToSortTest {

    private boolean canBeSorted;

    @org.junit.Test
    public void testCanBeSorted3ElEnd() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{1, 3, 2});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSorted4ElEnd() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{1, 3, 2, 2});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSorted3ElBeg() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{2, 1, 2});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSortedLongMid() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{1, 2, 1, 1, 2, 2});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSortedLongBegMid() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{2, 2, 1, 2, 2});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSortedLongMidEnd() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{1, 2, 1, 1, 2, 1});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSorted2El() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{2, 1});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSorted1El() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{1});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanBeSortedMidLong() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{1, 3, 6, 9, 7, 8, 7, 20, 20, 30});
        canBeSorted = a.canBeSorted();
        Assert.assertTrue(canBeSorted);
    }

    @org.junit.Test
    public void testCanNotBeSortedLong() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{3, 2, 1, 1, 2, 2});
        canBeSorted = a.canBeSorted();
        Assert.assertFalse(canBeSorted);
    }

    @org.junit.Test
    public void testCanNotBeSortedBegEnd() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{8, 1, 1, 1, 2, 7});
        canBeSorted = a.canBeSorted();
        Assert.assertFalse(canBeSorted);
    }

    @org.junit.Test
    public void testCanNotBeSortedBegEndGreater() throws Exception {
        ArrayToSort a = new ArrayToSort(new int[]{8, 1, 1, 1, 2, 9});
        canBeSorted = a.canBeSorted();
        Assert.assertFalse(canBeSorted);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIsNull() throws Exception {
        new ArrayToSort(null).canBeSorted();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIsEmpty() throws Exception {
        new ArrayToSort(new int[]{}).canBeSorted();
    }
}