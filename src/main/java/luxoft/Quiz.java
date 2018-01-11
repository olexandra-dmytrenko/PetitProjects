package luxoft;

/**
 * Created by olexandra on 11/5/17.
 */
public class Quiz {
    private static int foo = 42;

    public static void main(String[] args) {
        Quiz foo = new Quiz();
        System.out.println(foo.getFoo().foo);
    }

    private Quiz getFoo() {
        return null;
    }
}