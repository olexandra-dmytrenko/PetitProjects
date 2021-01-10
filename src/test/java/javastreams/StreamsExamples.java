package javastreams;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsExamples {

    @Test
    public void mapping() {

        List<String> list = Stream.of("1", "2", "3")
                .map(a -> a + a)
                .collect(Collectors.toList());

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
