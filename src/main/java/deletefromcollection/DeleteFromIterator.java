package deletefromcollection;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

/**
 * Created by Oleksandra_Dmytrenko on 3/15/2017.
 */
public class DeleteFromIterator {

    private static Map<Integer, String> map;

    private static ArrayList<String> list;
    private Predicate<String> contains1 = l -> l.contains("1");

    @Test(expectedExceptions = ConcurrentModificationException.class)
    public void forEachNoConcurrentEx() {
        for (String s : list) {
            list.remove(s);
        }
        assertEquals(list.size(), 0);
    }

    @Test
    public void noConcurExInArrayList(ArrayList<String> l) {
        Iterator i = l.iterator();
        while (i.hasNext()) {
            i.next();
            i.remove();
            assertEquals(list.size(), 0);
        }
    }

    @Test
    public void noConcurrentModificationException(Map<Integer, String> map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            System.out.println(map);
        }
        assertEquals(map.size(), 0);
    }

    @Test(expectedExceptions = ConcurrentModificationException.class)
    public void getConcurrentModificationException(Map<Integer, String> map) {
        Iterator im = map.entrySet().iterator();
        while (im.hasNext()) {
            Map.Entry e = (Map.Entry) im.next();
            map.remove(e.getKey());
            System.out.print(map);
        }
    }

    @BeforeMethod
    public void initForTest() {
        list = new ArrayList<>(Arrays.asList("1", "2", "12", "21", "24"));
        map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(21, "21");
        map.put(12, "12");
        map.put(24, "24");
    }

    @Test(expectedExceptions = ConcurrentModificationException.class)
    public void deleteFromStreamWithConcurEx() {
        list.stream().forEach(l -> list.remove(l));
    }

    @Test
    public void deleteFromListRemoveIf() {
        list.removeIf(contains1);
        assertEquals(list.size(), 2);
    }

    @Test
    public void deleteFromListPartitioning() {
        final Map<Boolean, List<String>> filteredMap = list.stream().collect(Collectors.partitioningBy(contains1));
        assertEquals(filteredMap.get(true).size(), 3);
        assertEquals(filteredMap.get(false).size(), 2);
    }

    @Test
    public void deleteFromListFilter() {
        List<String> listFiltered = list.stream().filter(contains1.negate()).collect(Collectors.toList());
        assertEquals(listFiltered.size(), 2);
    }

    @Test
    public void deleteFromMapPartitioning() {
        Predicate<Map.Entry<Integer, String>> contains1 = e -> e.getValue().contains("1");
        final Map<Boolean, List<Map.Entry<Integer, String>>> partitionedMap = map.entrySet().stream()
                .collect(Collectors.partitioningBy(contains1));
        assertEquals(partitionedMap.get(true).size(), 3);
        assertEquals(partitionedMap.get(false).size(), 2);
    }
}
