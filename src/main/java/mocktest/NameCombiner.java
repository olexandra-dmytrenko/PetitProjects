package mocktest;

/**
 * Created by olexandra on 1/11/18.
 */
class NameCombiner {

    private NameProducer myName;

    String calculateName(String name) {

        return myName.produceName() + " + " + name + " = friends";
    }
}
