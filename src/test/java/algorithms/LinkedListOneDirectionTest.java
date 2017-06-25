package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/25/17.
 */
public class LinkedListOneDirectionTest {
    @Test
    public void sizeOfFilledListShouldBeNotAsNumberOFElements() throws Exception {
        LinkedListOneDirection list = new LinkedListOneDirection();
        list.add("Награждение \n");
        list.add("Присудить грамоту ");
        list.add("Марине Сергеевне ");
        list.add("за высокие достижения в спорте.");
        assertEquals(list.size(), 4);
    }

    @Test
    public void sizeOfNewListShouldBe0() throws Exception {
        LinkedListOneDirection list = new LinkedListOneDirection();
        assertEquals(list.size(), 0);
    }

    @Test
    public void getFirstElementOutOf1() {
        LinkedListOneDirection list = new LinkedListOneDirection();
        String content = "Награждение \n";
        list.add(content);
        LinkedListElement actual = list.get(0);
        LinkedListElement expected = new LinkedListElement(content);
        assertEquals(actual, expected);
//        assertListOneDirectionElement(actual, expected);
    }

    private void assertListOneDirectionElement(LinkedListElement actual, LinkedListElement expected) {
        assertEquals(actual.getContent(), expected.getContent());
        assertEquals(actual.getNext(), expected.getNext());
    }

    @Test
    public void getFirstElementOutOf2() {
        LinkedListOneDirection list = new LinkedListOneDirection();
        String content1 = "Награждение \n";
        String content2 = "Присудить грамоту ";
        list.add(content1);
        list.add(content2);
        LinkedListElement actual = list.get(0);
        LinkedListElement expectedFirst = new LinkedListElement(content1);
        LinkedListElement expectedSecond = new LinkedListElement(content2);
        expectedFirst.setNext(expectedSecond);
//        assertEquals(actual.getContent(), expectedFirst.getContent());
//        assertListOneDirectionElement(actual.getNext(), expectedSecond);
        assertEquals(actual, expectedFirst);
        //       assertEquals(actual.getNext(), expectedSecond);
    }

    @Test
    public void getThirdElementOutOf4() {
        LinkedListOneDirection list = new LinkedListOneDirection();
        String content3 = "Марине Сергеевне ";
        String content4 = "Присудить грамоту ";
        list.add("Награждение \n");
        list.add("Присудить грамоту ");
        list.add(content3);
        list.add(content4);
        LinkedListElement actual = list.get(2);
        LinkedListElement expectedThird = new LinkedListElement(content3);
        LinkedListElement expectedFourth = new LinkedListElement(content4);
        expectedThird.setNext(expectedFourth);
        assertEquals(actual, expectedThird);
    }

    @Test
    public void getFourthElementOutOf4() {
        LinkedListOneDirection list = new LinkedListOneDirection();
        String content4 = "Присудить грамоту ";
        list.add("Награждение \n");
        list.add("Присудить грамоту ");
        list.add("Марине Сергеевне ");
        list.add(content4);
        LinkedListElement actual = list.get(3);
        LinkedListElement expectedFourth = new LinkedListElement(content4);
        assertEquals(actual, expectedFourth);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirstElementOutOf0ShouldThrowException() {
        LinkedListOneDirection list = new LinkedListOneDirection();
        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getSecondElementOutOf1ShouldThrowException() {
        LinkedListOneDirection list = new LinkedListOneDirection();
        String content = "Награждение \n";
        list.add(content);
        list.get(1);
    }
}