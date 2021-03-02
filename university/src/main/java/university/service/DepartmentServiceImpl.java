package university.service;

import java.util.Optional;

import university.exception.ProfessorNotFountException;
import university.exception.SubjectNotFountException;
import university.pojo.Professor;
import university.pojo.Subject;

import static java.util.Optional.of;

public class DepartmentServiceImpl implements DepartmentService {

    private SubjectService subjectService;

    @Override
    public Professor getProfessorBySubject(String subjectName) {
        return of(subjectName)
                .map(s -> subjectService.getSubjects().stream()
                        .filter(sub -> sub.getName().equals(s))
                        .findAny()
                        .map(Optional::of)
                        .orElseThrow(() -> new SubjectNotFountException(subjectName))
                        .map(Subject::getProf)
                        .orElseThrow(ProfessorNotFountException::new)

                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }

    public DepartmentService setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
        return this;
    }
}
