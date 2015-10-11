package sorting;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ToSortTest {

    public static ToSort t;

    @BeforeClass
    public static void setUp() throws Exception {
        t = new ToSort();
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{new String[]{"B", "A", "M"}, new String[]{"A", "B", "M"}},
                {new String[]{"0", "A", "M"}, new String[]{"0", "A", "M"}}});

    }

    @Parameterized.Parameter(0)
    public String[] givenV;

    @Parameterized.Parameter(1)
    public String[] expectedV;

    @Test
    public void testToSortArray() throws Exception {
        List<String> r = t.toSortArray(givenV);
        Assert.assertEquals(Arrays.asList(expectedV), r);
    }
//    @Test
//    public void testToSortArray() throws Exception {
//        List<String> r = t.toSortArray(new String[]{"B", "A", "M"});
//        Assert.assertEquals(Arrays.asList(new String[]{"A", "B", "M"}), r);
//    }
}