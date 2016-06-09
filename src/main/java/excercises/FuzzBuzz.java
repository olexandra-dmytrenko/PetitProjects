package excercises;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * Created by Oleksandra_Dmytrenko on 6/8/2016.
 * Problem : For a given natural number greater than zero return:
 “Fizz” if the number is dividable by 3
 “Buzz” if the number is dividable by 5
 “FuzzBuzz” if the number is dividable by 15
 the same number if number is neither divisible by 3 nor 5.

 Read more: http://javarevisited.blogspot.com/2015/04/fizzbuzz-solution-in-java-8.html#ixzz4AztPPN5L
 */
public class FuzzBuzz {
    public static Map<Integer, String> numberToString = new TreeMap<>(Collections.reverseOrder());
    private static BiFunction<Integer, Map.Entry<Integer, String>, String> fb = (n, d) -> n % d.getKey() == 0
            ? d.getValue() : "";



    static {
        numberToString.put(15, "FuzzBuzz");
        numberToString.put(5, "Buzz");
        numberToString.put(3, "Fuzz");
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Result: " + fuzzBuzz(number));
    }

    public static String fuzzBuzz(int number) {
        // return numberToString.entrySet().stream().filter(e -> number%e.getKey() ==
        // 0).limit(1).map(e -> e.getValue())
        // .sorted(Comparator.reverseOrder())
        return numberToString.entrySet().stream().map(e -> number % e.getKey() == 0 ? e.getValue() : null)
                .peek(System.out::println).filter(e -> e != null).findFirst().orElse(number + "");
    }

    public static String fuzzBuzzOptional(int number) {
        return Optional
                .of(number).map(n -> numberToString.entrySet().stream()
                        .map(d -> n % d.getKey() == 0 ? d.getValue() : null).filter(e -> e != null).findFirst())
                .get().orElse(number + "");
    }

    public static String fuzzBuzzOptionalManual(int number) {
        return Optional.of(number).map(n -> (n % 3 == 0 ? "Fuzz" : "") + (n % 5 == 0 ? "Buzz" : ""))
                .map(s -> s.isEmpty() ? number + s : s).get();
    }

    public static String fuzzBuzzOptionalManualWithOneMap(int number) {
        String result = Optional.of(number).map(n -> (n % 3 == 0 ? "Fuzz" : "") + (n % 5 == 0 ? "Buzz" : "")).get();
        return result.isEmpty() ? Integer.toString(number) : result;
    }
}
