package arrays;

import java.util.Collections;
import java.util.List;

/**
 * Created by Oleksandra_Dmytrenko on 13/03/2018.
 */
public class NullableLists {
    public <T> List<T> arrayToList(T... ts) {
//        T[] m = new T[0];
        String[] s = new String[0];
//        List<String> tList = Optional.of(ts).orElseGet(String[0]::new);
        return Collections.emptyList();
    }
}