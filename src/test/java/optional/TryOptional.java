package optional;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

/**
 * Created by olexandra on 11/3/16.
 */
public class TryOptional {
    @Test
    public void optionalVsNonOptional() {
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

    @Test(expectedExceptions = NullPointerException.class)
    public void nullList(){
        List<String> l = null;
        String o = l.stream().findFirst().orElse(null);
        //assertNull(o);
    }

    @Test
    public void optionalNullList(){
        List<String> l = null;
        String o = Optional.ofNullable(l).flatMap(list -> list.stream().findFirst()).orElse(null);
        assertNull(o);
    }

    @Test
    public void optionalEmptyList(){
        List<String> l = emptyList();
        String o = Optional.ofNullable(l).flatMap(list -> list.stream().findFirst()).orElse(null);
        assertNull(o);
    }

    @Test
    public void optionalNotEmptyList(){
        List<String> l = singletonList("s");
        String o = Optional.ofNullable(l).flatMap(list -> list.stream().findFirst()).orElse(null);
        assertNotNull(o);
    }

    @Test
    public void notNullList(){
        List<String> l = Collections.singletonList("1");
        String o = l.stream().findFirst().orElse(null);
        assertNotNull(o);
    }

}
