package testingGoIT6;

import org.junit.Assert;

public class OneSwipeArrayTest {
    private boolean solution;

    @org.junit.Test
    public void testsolution3ElEnd() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{1, 3, 2});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolution4ElEnd() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{1, 3, 2, 2});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolution3ElBeg() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{2, 1, 2});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolutionLongMid() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{1, 2, 1, 1, 2, 2});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolutionLongBegMid() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{2, 2, 1, 2, 2});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolutionLongMidEnd() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{1, 2, 1, 1, 2, 1});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolution2El() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{2, 1});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolution1El() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{1});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testsolutionMidLong() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{1, 3, 6, 9, 7, 8, 7, 20, 20, 30});
        solution = a.solution();
        Assert.assertTrue(solution);
    }

    @org.junit.Test
    public void testCanNotBeSortedLong() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{3, 2, 1, 1, 2, 2});
        solution = a.solution();
        Assert.assertFalse(solution);
    }

    @org.junit.Test
    public void testCanNotBeSortedBegEnd() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{8, 1, 1, 1, 2, 7});
        solution = a.solution();
        Assert.assertFalse(solution);
    }

    @org.junit.Test
    public void testCanNotBeSortedBegEndGreater() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{8, 1, 1, 1, 2, 9});
        solution = a.solution();
        Assert.assertFalse(solution);
    }

    @org.junit.Test
    public void testCanNotBeSorted2Repl() throws Exception {
        OneSwipeArray a = new OneSwipeArray(new int[]{2, 1, 2, 1, 1, 2, 9});
        solution = a.solution();
        Assert.assertFalse(solution);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIsNull() throws Exception {
        new OneSwipeArray(null).solution();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIsEmpty() throws Exception {
        new OneSwipeArray(new int[]{}).solution();
    }
}
