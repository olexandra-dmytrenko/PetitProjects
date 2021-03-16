package service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import exception.ProfessorNotFountException;
import exception.SubjectNotFountException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import model.Professor;
import model.Subject;

import static java.util.Optional.of;

@RequiredArgsConstructor
@Service
@Setter
//TODO: discuss
@Accessors(chain = true)
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
                        .map(Subject::getProfessor)
                        .orElseThrow(ProfessorNotFountException::new)

                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }
}
