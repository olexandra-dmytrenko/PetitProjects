package anything;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TryAnything {
    @Test
    public void intMax(){
        System.out.println((Long.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE + 1, Integer.MIN_VALUE);
    }
}
