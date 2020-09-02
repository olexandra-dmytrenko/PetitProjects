package anything;

import org.junit.Assert;
import org.junit.Test;

public class ReturnFinallyTest {

    private int returnFinally_int() {
        int a = 1;
        try {
            return ++a;
        } finally {
            ++a;
            System.out.println(a);
        }
    }

    private int returnFinally_Integer() {
        Integer a = 1;
        try {
            return ++a;
        } finally {
            ++a;
            System.out.println(a);
        }
    }

    @Test
    public void testReturn_int() {
        Assert.assertEquals(2, returnFinally_int());
    }

    @Test
    public void testReturn_Integer() {
        Assert.assertEquals(2, returnFinally_Integer());
    }
}
