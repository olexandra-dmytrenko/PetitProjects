package repository;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Collections;
import java.util.List;

import university.pojo.Professor;
import university.pojo.Subject;

//CRUD operations
public class SubjectRepository {
    public Professor findProfessorById(long id) {
        throw new NotImplementedException();
    }

    public long createProfessor(Professor professor) {
        return 0;
    }

    public Subject createProfessor(Subject subject) {
        return new Subject("Math", new Professor("Sasha"));
    }

    public Professor updateProfessorById(Professor professor) {
        throw new NotImplementedException();
    }

    public List<Subject> getAllSubjects() {
        return Collections.emptyList();
    }

    public void deleteProfessor(long id) {
    }
}
