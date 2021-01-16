package javastreams;

import org.junit.Test;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsExamples {

    @Test
    public void mapping() {

        List<String> list = Stream.of("1", "2", "3")
                .map(a -> a + a)
                .collect(Collectors.toList());

        final String prayer = Stream.of("I", "pray", "to", "God", "for", "help")
                .collect(Collectors.joining(" ", "", "."));
        Assert.assertEquals("I pray to God for help.", prayer);

        double averageLength = Stream.of("I", "pray", "to", "God", "for", "help")
                .mapToInt(String::length)
                .average()
                .orElse(0);


        final double averageLength1 = Stream.of("I", "pray", "to", "God", "for", "help")
                .map(s -> s.length()).reduce(0, (a, b) -> a + b).doubleValue() / 5;


        Assert.assertEquals(2.83, averageLength, 0.5);
        Assert.assertEquals(3.0, averageLength1, 0.5);

        List<Integer> list1 = Stream.of(1, 2, 3)
                .map(a -> a + a)
                .collect(Collectors.toList());

        List<Integer> listOfOddNumbers = Stream.of(1, 2, 3)
                .collect(Collectors.filtering(i -> i % 2 != 0, toList()));

        List<Integer> listOfOddNumbers1 = Stream.of(1, 2, 3).filter(i -> i % 2 != 0).limit(2)
                .collect(Collectors.toList());

        List<Integer> listOfSquares = Stream.of(1, 2, 3)
                .collect(Collectors.mapping(i -> i * i, toList()));
    }
}
