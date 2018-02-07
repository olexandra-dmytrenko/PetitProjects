package regexp;

/**
 * Created by Oleksandra_Dmytrenko on 06/02/2018.
 */
public class Splitting {
    public static String[] splitter(String body){
        return body.split("((\r\n){2,}|\\.|\\;)");
    }
}
