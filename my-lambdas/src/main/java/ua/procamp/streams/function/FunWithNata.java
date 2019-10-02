package ua.procamp.streams.function;

import java.util.function.Function;

public class FunWithNata {

    public static Integer counter = 0;
    public Integer ownCounter = 0;

    public FunWithNata() {
        counter++;
        ownCounter++;
    }

    public static void main(final String... strs) {
        FunWithNata funWithNata = new FunWithNata();
        FunWithNata funWithNata1 = new FunWithNata();
        final String counterString = funWithNata.intToStrConverter().apply(counter);
        //counterString = counterString.substring(1);
        final String counterString1 = funWithNata1.intToStrConverter().apply(counter);
        System.out.println("Number of instances: " + counterString);
        System.out.println("Number of own instances: " +
                funWithNata.intToStrConverter().apply(funWithNata.ownCounter));
        System.out.println("Number of instances1: " + counterString1);
        System.out.println("Number of own instances1: " +
                funWithNata1.intToStrConverter().apply(funWithNata1.ownCounter));
    }

    private Function<Integer, String> intToStrConverter() {
        return i -> i.toString();
    }
}