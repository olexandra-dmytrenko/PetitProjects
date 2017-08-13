package java8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

/**
 * Created by Oleksandra_Dmytrenko on 5/18/2017.
 */
public class TryLittleStuff {
    @Test
    public void maxOfShortWithNull() {
//        Short m = Collections.max(Arrays.asList((short) 1, (short) 3, (short) -3, null).stream().flatMapToInt());
//        Short m = Stream.of((short) 1, (short) 3, (short) -3, null)
//                .flatMapToInt(Short::intValue) .max(Short::compare).orElse((short) 0);
//        assertTrue(m == (short) -3);
    }

    @Test
    public void ifIsEmptyCheckIsNeeded(){
        @Getter
        class Person{
            String name;
            int age;
        }
        List<Person> list = Collections.emptyList();
        boolean isPresent = list.stream().allMatch(l -> l.getName().equals("Sasha"));
        Assert.assertFalse(isPresent);
    }
}
