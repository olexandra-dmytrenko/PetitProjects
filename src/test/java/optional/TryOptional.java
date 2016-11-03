package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by olexandra on 11/3/16.
 */
public class TryOptional {
    public static void main(String[] args) {
        noOptional();
        optional();
    }

    private static void noOptional() {
        List<String> list = Arrays.asList("a", null, "bd");
//        OptionalDouble sum = list.stream().mapToInt(String::length).average();
        double sum = list.stream().map(s -> s == null ? "" : s).mapToInt(String::length).average().orElse(0);
//        sum.orElseGet(null);
//        System.out.println("Average = " + (sum.isPresent() ? sum.getAsDouble() : null));
//        System.out.println("Average = " + sum.orElseGet(null));
        System.out.println("Average = " + sum);
    }


    private static void optional() {
        List<Optional<String>> list = Arrays.asList(Optional.of("qw1"), Optional.ofNullable(null), Optional.empty());
//        OptionalDouble sum = list.stream().mapToInt(String::length).average();
        double sum = list.stream().map(o -> o.orElse("")).mapToInt(String::length).average().orElse(0);
        System.out.println("Average = " + sum);
    }

}
