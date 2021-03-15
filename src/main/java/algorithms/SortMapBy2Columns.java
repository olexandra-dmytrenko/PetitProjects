package algorithms;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortMapBy2Columns {
    public static void main(String[] args) {
        //interview for Erbis transport company
        String names = "Charlie Jennifer Charlie Bob Charlie Charlie Bob Jennifer Alice Alice ";
        final String[] namesList = names.split(" ");
        Stream.of(namesList)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> ((Map.Entry<String, Long>)entry).getValue()).reversed()
                        .thenComparing(entry -> ((Map.Entry<String, Long>)entry).getKey()))
                .forEach(System.out::println);
    }
}
