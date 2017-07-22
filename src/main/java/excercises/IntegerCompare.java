package excercises;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Oleksandra_Dmytrenko on 3/20/2017.
 */
public class IntegerCompare {
    @Test
    public void compareIntegersAsObjects() {
        Integer a = new Integer(2);
        Integer b = new Integer(2);
        assertFalse(a == b);
        assertTrue(a.equals(b));
    }

    @Test
    public void compareIntegersAsNotObjects() {
        Integer a = 1;
        Integer b = 1;
        assertTrue(a == b);
        assertTrue(b.equals(a));
    }

    @Test
    public void compareNulls() {
        Integer a = null;
        Integer b = null;
        assertTrue(a == b);
        //     assertFalse(a.equals(b)); // causes NullPointerExeption
    }

    @Test
    public void compareNullAndNotNull() {
        Integer a = null;
        Integer b = 1;
        assertFalse(b.equals(a));
//        assertFalse(a.equals(b)); // causes NullPointerExeption
    }
}