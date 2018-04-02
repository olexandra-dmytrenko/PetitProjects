package arrays;

import org.junit.Test;

import java.util.List;

/**
 * Created by Oleksandra_Dmytrenko on 13/03/2018.
 */
public class NullableListsTest {
    @Test
    public void arrayToList() throws Exception {
        NullableLists test = new NullableLists();
        List<String> strings = test.arrayToList(null);
        System.out.println(strings);
    }

}