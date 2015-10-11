package sorting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by olexandra on 11.10.15.
 */
public class ToSort {

    public List<String> toSortArray(String[] a) {
        List<String> s = Stream.of(a).sorted().collect(Collectors.toList());
        return s;
    }
}
