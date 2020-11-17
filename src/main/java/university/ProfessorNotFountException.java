package university;

import java.util.NoSuchElementException;

public class ProfessorNotFountException extends NoSuchElementException {

    public ProfessorNotFountException() {
        super("No prof found");
    }
}