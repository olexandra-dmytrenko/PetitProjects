package university.service;

import org.junit.Test;

import university.exception.ProfessorNotFountException;
import university.exception.SubjectNotFountException;
import university.pojo.MyDepartment;
import university.pojo.Professor;
import university.pojo.Subject;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private static final String DEPARTMENT_TEF = "TEF";
/*
    @Test
    public void whenFindProfByExistingSubject_ProfFound() {
        // GIVEN
        final MyDepartment d = new MyDepartment(DEPARTMENT_TEF);
        final Subject subject = new Subject("Math", new Professor("Gavrylo Petrovych"));

        assertNotNull(d.getProfessorBySubject("Math"));
    }

    @Test(expected = SubjectNotFountException.class)
    public void whenFindProfByNonExistingSubject_ThrowSubjectNotFoundEx() {
        // GIVEN
        final MyDepartment d = new MyDepartment(DEPARTMENT_TEF);
        final Subject subject = new Subject("Math", new Professor("Gavrylo Petrovych"));
        //WHEN
        d.getProfessorBySubject("Math1");
    }

    @Test(expected = ProfessorNotFountException.class)
    public void whenFindNonExistingProfByExistingSubject_ThrowSubjectNotFoundEx() {
        // GIVEN
        final MyDepartment d = new MyDepartment(DEPARTMENT_TEF);
        //WHEN
        d.getProfessorBySubject("Science");
    }

*/
}