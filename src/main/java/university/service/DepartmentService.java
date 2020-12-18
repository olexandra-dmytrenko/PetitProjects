package university.service;

import org.jetbrains.annotations.TestOnly;

import java.util.Optional;

import university.exception.ProfessorNotFountException;
import university.exception.SubjectNotFountException;
import university.pojo.Professor;
import university.pojo.Subject;

import static java.util.Optional.of;

public class DepartmentService {

    private SubjectService subjectService;

    public DepartmentService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

     public Professor getProfessorBySubject(String subjectName) {
        return of(subjectName)
                .map(s -> subjectService.getSubjects().stream()
                        .filter(sub -> sub.getName().equals(s))
                        .findAny()
                        .map(Optional::of)
                        .orElseThrow(SubjectNotFountException::new)
                        .map(Subject::getProf)
                        .orElseThrow(ProfessorNotFountException::new)

                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }
}
