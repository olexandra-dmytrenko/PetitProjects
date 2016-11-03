package anything;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

/**
 * Created by olexandra on 3/28/16.
 */
public class IntDevision {
    @Test
    public void divideRounding4Over3(){
        assertEquals(4/3, 1);
    }
    @Test
    public void divideRounding5Over2(){
        assertEquals(5/2, 2);
    }
    @Test
    public void divideRounding8Over3(){
        Map ds = new HashMap<>();
        assertEquals(8/3, 2);

        Stream.of(1, 2).parallel();
    }
}
