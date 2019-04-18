import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * https://www.baeldung.com/akka-streams
 * https://github.com/eugenp/tutorials/blob/master/akka-streams/pom.xml
 */
@Getter
@Setter
@AllArgsConstructor
public class DataImporter {
    private ActorSystem actorSystem;
    private final Repository averageRepository = new Repository();

    private List<Integer> parseLine(String line) {
        String[] fields = line.split(";");
        return Arrays.stream(fields)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Flow<String, Integer, NotUsed> parseContent() {
        return Flow.of(String.class).mapConcat(this::parseLine);
    }

    public Flow<Integer, Double, NotUsed> computeAverage() {
        return Flow.of(Integer.class)
                .grouped(2)
                .mapAsyncUnordered(1, integers ->
                        CompletableFuture.supplyAsync(() ->
                                integers.stream()
                                        .mapToDouble(v -> v)
                                        .sum()));
    }

    public Flow<String, Double, NotUsed> stringToAverage(){
        return Flow.of(String.class)
                .via(parseContent())
                .via(computeAverage());
    }



    private Sink<Double, CompletionStage<Done>> storeAverages(){
        return Flow.of(Double.class)
                .mapAsyncUnordered(4, averageRepository::save)
                .toMat(Sink.ignore(), Keep.right());
    }

    CompletionStage<Done> calculateAvFor(String content){
        return Source.single(content)
                .via(stringToAverage())
                .runWith(storeAverages(), ActorMaterializer.create(actorSystem))
                .whenComplete((d, e) -> {
                    if (d!=null){
                        System.out.println("Import finished with result: " + d);
                    }else {e.printStackTrace();};
                });
    }
}