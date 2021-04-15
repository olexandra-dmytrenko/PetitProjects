package ua.kpi.tef.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import ua.kpi.tef.exception.SubjectNotFountException;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.model.Subject;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplMockitoTest {

    private static final String SUBJECT_MATH = "Math";
    private static final Professor PROFESSOR_NAME = new Professor("Name");

    @Mock
    private SubjectServiceImpl subjectServiceImpl;// = Mockito.mock(SubjectService.class);
    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;// = new DepartmentService(subjectService);

    @Test
    public void getProfessorBySubject_whenSubjIsValid_thenReturnProf() {
        //GIVEN
        final List<Subject> subjects = Collections.singletonList(
                new Subject(SUBJECT_MATH, PROFESSOR_NAME));
        //Mockito.when(subjectService.getSubjects()).then(subjects);
        Mockito.doReturn(subjects).when(subjectServiceImpl).getSubjects();

        //WHEN
        final Professor actual = departmentServiceImpl.getProfessorBySubject(SUBJECT_MATH);

        //THEN
        Mockito.verify(subjectServiceImpl, Mockito.times(1)).getSubjects();
        Assertions.assertEquals(actual, PROFESSOR_NAME);
    }

    @Test
    public void getProfessorBySubject_whenSubjIsInvalid_thenThrowSubjectEx() {
        //GIVEN
        final List<Subject> subjects = Collections.singletonList(
                new Subject(SUBJECT_MATH, PROFESSOR_NAME));
        //Mockito.when(subjectService.getSubjects()).then(subjects);
        Mockito.doReturn(subjects).when(subjectServiceImpl).getSubjects();

        //WHEN THEN
        Assertions.assertThrows(SubjectNotFountException.class, () -> departmentServiceImpl.getProfessorBySubject(SUBJECT_MATH + "1"));
    }
}
