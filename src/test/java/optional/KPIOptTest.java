package optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class KPIOptTest {

    @Test
    public void shouldReturnEmpty_whenOnNullObject() {
        KPIOpt.Person person = null;
        Optional<Integer> age = Optional.ofNullable(person).map(p -> p.age);

        assertNull(person);
        assertEquals(Optional.empty(), age);
    }

    @Test
    public void shouldReturnAge_whenOnInitialisedObject() {
        KPIOpt.Person person = new KPIOpt.Person("myself", 3);
        Optional<Integer> age = Optional.ofNullable(person).map(p -> p.age);

        assertNotNull(person);
        assertEquals(3, age.get(), 0.1);
    }

    @Test
    public void shouldReturnEmpty1_whenOnNullObject() {
        KPIOpt.Person person = new KPIOpt.Person("myself", null);
        Optional<Integer> age = Optional.ofNullable(person).map(p -> p.age);

        if (age.isPresent()) {
            assertNotNull(person);
            assertEquals(3, age.get(), 0.1);
        }
    }
}