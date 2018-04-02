package datetime;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleksandra_Dmytrenko on 15/03/2018.
 */
public class DeteTimeFormattedTest {
    @Test
    public void getCurrentIsoDateTimeCompareToLocalDateTimeFormatted() throws Exception {
        DeteTimeFormatted dt = new DeteTimeFormatted();
        assertEquals(dt.getCurrentIsoDateTime(), dt.getDateTimeFormated());
    }
}