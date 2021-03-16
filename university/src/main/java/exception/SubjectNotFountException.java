package exception;

import java.util.NoSuchElementException;

public class SubjectNotFountException extends NoSuchElementException {

    public SubjectNotFountException(String subjectName) {
        super("No subject " + subjectName + " found");
    }
}