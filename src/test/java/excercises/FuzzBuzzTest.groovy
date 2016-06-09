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

//---------------------------------------------
    def "FuzzBuzzOptional3"() {
        expect:
        FuzzBuzz.fuzzBuzzOptional(3).equals("Fuzz");
    }

    def "FuzzBuzzOptional5"() {
        expect:
        FuzzBuzz.fuzzBuzzOptional(5).equals("Buzz");
    }

    def "FuzzBuzzOptional15"() {
        expect:
        FuzzBuzz.fuzzBuzzOptional(15).equals("FuzzBuzz");
    }

    def "FuzzBuzzOptional4"() {
        expect:
        FuzzBuzz.fuzzBuzzOptional(4).equals("4");
    }
//---------------------------------------------
    def "FuzzBuzzOptionaManuall3"() {
        expect:
        FuzzBuzz.fuzzBuzzOptionalManual(3).equals("Fuzz");
    }

    def "FuzzBuzzOptionalManual5"() {
        expect:
        FuzzBuzz.fuzzBuzzOptionalManual(5).equals("Buzz");
    }

    def "FuzzBuzzOptionalManual15"() {
        expect:
        FuzzBuzz.fuzzBuzzOptionalManual(15).equals("FuzzBuzz");
    }

    def "FuzzBuzzOptionalManual4"() {
        expect:
        FuzzBuzz.fuzzBuzzOptionalManual(4).equals("4");
    }
}
