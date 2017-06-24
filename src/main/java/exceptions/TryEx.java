package exceptions;

/**
 * Created by olexandra on 2/27/17.
 */
public class TryEx {
    public static void main(String[] args) {

    }

    public void tryEr() {
        throw new MyError();
    }

    public void tryEx() throws MyEx {
        throw new MyEx();
    }

    public void tryExTryCathc() {
        try {
            throw new MyEx();
        } catch (MyEx myEx) {
            myEx.printStackTrace();
        }
    }

    public void tryRuntimeEx() {
        throw new MyRuntimeEx();
    }
}
