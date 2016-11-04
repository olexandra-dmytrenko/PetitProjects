package lazy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Oleksandra_Dmytrenko on 11/4/2016.
 */
public class Mapping {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("q", "23");
        String a = list.stream().map(s -> {
            System.out.println(s);
            return s + "Y";
        })
//                .peek(s -> System.out.println(s))

                .filter(s -> true)
                .findFirst().get();
        System.out.println(a);
    }
}
