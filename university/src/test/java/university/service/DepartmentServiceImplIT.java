package university.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

import university.exception.SubjectNotFountException;
import university.pojo.Professor;
import university.pojo.Subject;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplIT {

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
        Assert.assertEquals(actual, PROFESSOR_NAME);

    }

    @Test(expected = SubjectNotFountException.class)
    public void getProfessorBySubject_whenSubjIsInvalid_thenThrowSubjectEx() {
        //GIVEN
        final List<Subject> subjects = Collections.singletonList(
                new Subject(SUBJECT_MATH, PROFESSOR_NAME));
        //Mockito.when(subjectService.getSubjects()).then(subjects);
        Mockito.doReturn(subjects).when(subjectServiceImpl).getSubjects();

        //WHEN
        final Professor actual = departmentServiceImpl.getProfessorBySubject(SUBJECT_MATH + "1");

        //THEN
        //  Assert.assertThrows(SubjectNotFountException::new);

    }
}
