import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.testkit.javadsl.TestSink;

import static org.junit.Assert.assertEquals;

public class DataImporterTest {
    private ActorSystem actorSystem = ActorSystem.create();

    @Test
    public void givenStreamOfIntegers_whenCalculateAverageOfPairs_thenShouldReturnProperResults() throws InterruptedException, ExecutionException, TimeoutException {
        Flow<String, Double, NotUsed> tested = new DataImporter(actorSystem).stringToAverage();

        String input = "1;3;2;4"; //av = 3

        //when
        Source flow = Source.single(input).via(tested);
        //then

        final CompletionStage<Double> future = Source.single(input).via(tested).runWith(Sink.fold(1d, (agg, next) -> agg * next), ActorMaterializer.create(actorSystem));
        final Double result = future.toCompletableFuture().get(10, TimeUnit.SECONDS);
        assertEquals(3.0, result, 0.1);
        //        flow
//                .runWith(TestSink.probe(actorSystem), ActorMaterializer.create(actorSystem));
//                .request(4)
//                .expectNextUnordered(5d, 5.5);
    }

    @Test
    public void myTest() throws InterruptedException, ExecutionException, TimeoutException {

        final Flow<Integer, Integer, NotUsed> flowUnderTest =
                Flow.of(Integer.class).takeWhile(i -> i < 5);

        final CompletionStage<Integer> future =
                Source.from(Arrays.asList(1, 2, 3, 4, 5, 6))
                        .via(flowUnderTest)
                        .runWith(Sink.fold(0, (agg, next) -> agg + next), ActorMaterializer.create(actorSystem));
        final Integer result = future.toCompletableFuture().get(3, TimeUnit.SECONDS);
        assert (result == 10);
    }

}