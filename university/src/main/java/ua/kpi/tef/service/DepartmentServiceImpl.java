package ua.kpi.tef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ua.kpi.tef.exception.ProfessorNotFountException;
import ua.kpi.tef.exception.SubjectNotFountException;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.model.Subject;

import static java.util.Optional.of;

@RequiredArgsConstructor
@Service
@Setter
@Getter
@Accessors(chain = true)
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
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
