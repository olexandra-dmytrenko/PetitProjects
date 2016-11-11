package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Created by olexandra on 12/1/15.
 */
public class Java8 {
    public static void main(String args[]) {
        List<String> names1 = new ArrayList<>();
        names1.add("Mahesh ");
        names1.add("Suresh ");
        names1.add("Ramesh ");
        names1.add("Naresh ");
        names1.add("Kalpesh ");

        Java8.sortUsingJava8(names1);
        System.out.println(names1);

        GreetingService greet = (message) -> System.out.println(" Hay" + message);
        greet.saySomething(names1.toString());

        MathOp add = (a, b) -> a + b;
        MathOp div = (a, b) -> a / b;
        System.out.println(add.operation(2, 3));
        System.out.println(operate(4, 3, div));
        StringJoiner s = new StringJoiner("ds", " pre", " pos");
        System.out.println(s.length());

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "2");
        map.put(3, "3");
        map.put(1, "1");

        map.entrySet().stream().forEach(System.out::println);
//        map.entrySet().stream().forEach(e -> System.out.println(e));

        System.out.println(map);
//        System.out.println(map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).
//                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2)->v1,
//                        LinkedHashMap::new)));

//        map.stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
//                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

        /*
         * You can sort a map by value as below, more example here
         *
         * //Sort a Map by their Value. Map<Integer, String> random = new HashMap<Integer,
         * String>();
         *
         * random.put(1,"z"); random.put(6,"k"); random.put(5,"a"); random.put(3,"f");
         * random.put(9,"c");
         *
         * Map<Integer, String> sortedMap = random.entrySet().stream()
         * .sorted(Map.Entry.comparingByValue()) .collect(Collectors.toMap(Map.Entry::getKey,
         * Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)); System.out.println(
         * "Sorted Map: " + Arrays.toString(sortedMap.entrySet().toArray()));
         */
        List<String> strings = Arrays.asList("abc", "", "abc", "efg", "abcd", "", "jkl");
        System.out.println(strings.stream().filter(e -> !e.isEmpty()).distinct().count());

        Stream<List<String>> stream = Collections.EMPTY_LIST.stream();
        //List<String> last = stream.reduce((a, b) -> b);
        System.out.println(strings.stream().unordered());

    }

    private static void sortUsingJava8(List<String> names1) {
        Collections.sort(names1, String::compareTo);
        // Collections.sort(names1, (e1, e2) -> e1.compareTo(e2));
    }

    private static int operate(int a, int b, MathOp op) {
        return op.operation(a, b);
    }

    interface GreetingService {
        void saySomething(String message);
    }

    interface MathOp {
        int operation(int a, int b);
    }

    /*
     * Try<Integer> divide (Integer one ,Integer two){ return Try.of(one / two); }
     */

}
