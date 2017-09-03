package algorithms;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by olexandra on 8/22/17.
 */
public class SumArrayPartsTest {
    @Test
    public void testSolution() throws Exception {
        int[] A = {1, -1, 3};
        int solution = SumArrayParts.solution4(A);
        assertEquals(solution, 1);
    }
    @Test
    public void testSolution1() throws Exception {
        int[] A = {1, 2, 3, 4, -5};
        int solution = SumArrayParts.solution4(A);
        assertEquals(solution, 1);
    }

    @Test
    public void testSolution2() throws Exception {
        int[] A = {1, 2, -3, 4, -5};
        int solution = SumArrayParts.solution4(A);
        assertEquals(solution, 1);
    }
    @Test
    public void testSolution3() throws Exception {
        int[] A = {1, 2, 3, 4, 5};
        int solution = SumArrayParts.solution5(A);
        assertEquals(solution, 3);
    }

    @Test
    public void testSolution4() throws Exception {
        int[] A = {-1000, 1000};
        int solution = SumArrayParts.solution4(A);
        assertEquals(solution, 2000);
    }

    @Test
    public void testSolution6() throws Exception {
        int[] A = {-10, 2, 10};
        // -10, -8, 2
        // 2+20 = 22 - in mine
        // 2 + 8 = 10
        //----
        //-10 - 12 = 22
        // -8 - 10 = 18
        int solution = SumArrayParts.solution5(A);
        assertEquals(solution, 18);
    }

    @Test
    public void testSolution5() throws Exception {
        int[] A = {3, 1, 2, 4, 3};
        int solution = SumArrayParts.solution4(A);
        assertEquals(solution, 1);
    }

}