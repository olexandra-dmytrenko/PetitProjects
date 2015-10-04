package enumgeneralization;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NamesTest {

    @Test
    public void testGetNameByPettingNameRight() throws Exception {
        assertEquals(Names.PASHA, Names.getNameByPettingName("Pashen'ka"));
    }
    @Test
    public void testGetNameByPettingNameWrong() throws Exception {
        assertNotEquals(Names.SASHA, Names.getNameByPettingName("Pashen'ka"));
    }
}