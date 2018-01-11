package mocktest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by olexandra on 1/11/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class NameCombinerTest {

    @Mock
    private NameProducer myName;

    @InjectMocks
    private NameCombiner nameCombiner;

    @Test
    public void calculateName() throws Exception {
        //GIVEN
        when(myName.produceName()).thenReturn("Petia");

        //WHEN
        String actual = nameCombiner.calculateName("Sasha");

        //THEN
        assertEquals("Petia + Sasha = friends", actual);
    }

}