package university;

import java.util.NoSuchElementException;

public class SubjectNotFountException extends NoSuchElementException {

    public SubjectNotFountException() {
        super("No subject found");
    }
}