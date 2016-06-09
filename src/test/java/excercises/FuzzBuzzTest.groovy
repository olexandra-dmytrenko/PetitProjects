package excercises

import spock.lang.Specification

/**
 * Created by Oleksandra_Dmytrenko on 6/9/2016.
 */
class FuzzBuzzTest extends Specification {
    def "FuzzBuzz3"() {
        expect:
        FuzzBuzz.fuzzBuzz(3).equals("Fuzz");
    }

    def "FuzzBuzz5"() {
        expect:
        FuzzBuzz.fuzzBuzz(5).equals("Buzz");
    }

    def "FuzzBuzz15"() {
        expect:
        FuzzBuzz.fuzzBuzz(15).equals("FuzzBuzz");
    }

    def "FuzzBuzz4"() {
        expect:
        FuzzBuzz.fuzzBuzz(4).equals("4");
    }
}
