import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Repository {
    public CompletionStage<Double> save(Double average) {
        return CompletableFuture.supplyAsync(() ->//save to DB
                {
                    System.out.println("saving average: " + average);
                    return average;
                }
        );
    }
}
