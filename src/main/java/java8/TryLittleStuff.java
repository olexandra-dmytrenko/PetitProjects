package java8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.testng.Assert.assertFalse;
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
        assertFalse(isPresent);
    }

    @Getter @AllArgsConstructor
    class Agreement{
        List<Boolean> isActive;
    }
    @Test
    public void whatOptionalRefersToBody(){
        Agreement aWithField = new Agreement(Collections.singletonList(true));
        Boolean actual = Optional.ofNullable(aWithField)
                .filter(agreement -> null != agreement.getIsActive())
                .map(agreement -> agreement.getIsActive().get(0)).orElse(false);
        assertTrue(actual);
    }
    @Test
    public void whatOptionalRefersToMethodResult(){
        Agreement aWithField = null;
        Boolean actual = Optional.ofNullable(aWithField)
                .filter(agreement -> null != agreement.getIsActive())
                .map(agreement -> agreement.getIsActive().get(0)).orElse(false);
        assertFalse(actual);
    }

    @Test
    public void whatOptionalRefersTo(){
        Agreement aWithField = new Agreement(Collections.singletonList(true));
        Boolean actual = Optional.ofNullable(aWithField)
                .filter(agreement -> false == agreement.getIsActive().get(0))
                .map(agreement -> agreement.getIsActive().get(0)).orElse(false);
        assertFalse(actual);
    }

    @Test
    public void whichNullOptionalRefersTo(){
        Agreement aWithField = null;
        Optional.ofNullable(aWithField.getIsActive()).filter( a -> a!=null).ifPresent(a -> System.out.println(a));

    }

    @Test
    public void withOrElseGet(){
        String emptyString = (String) Optional.ofNullable(null).orElseGet(() -> {
            System.out.println("Should be printed");
            return "";
        });
    }
}
