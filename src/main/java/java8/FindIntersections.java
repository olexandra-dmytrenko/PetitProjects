package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Oleksandra_Dmytrenko on 11/11/2016.
 */
public class FindIntersections {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 5, 2, 7, 8, 4, 3, 2, 1); // first and last intersect
        List<Integer> list = Arrays.asList(5, 2, 2, 7, 8, 4, 3, 1); // intersection in a row
//        List<Integer> list = Arrays.asList(5, 2, 7, 8, 4, 3, 1); // no intersections

        boolean hasIntersections = IntStream.range(1, list.size())
                .anyMatch(i -> list.stream().skip(i)
                        .anyMatch(el -> list.get(i - 1).equals(el)));
        System.out.println("Intersections are found: " + hasIntersections);

        int result = IntStream.range(0, list.size() - 1)
                .filter(i -> list.stream().skip(i + 1)
                        .anyMatch(el -> list.get(i).equals(el)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("There are no repeatable arguments"));
        System.out.println("The intersection int is " + list.get(result));
    }
}
