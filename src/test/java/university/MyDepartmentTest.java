package university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyDepartmentTest {

    private static final String DEPARTMENT_NAME_1 = "Dep1";
    private static final String DEPARTMENT_NAME_2 = "Dep2";
    private static final String DEPARTMENT_TEF = "TEF";

    @Before
    public void setUp() {
    }

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

    @Test
    public void departmentsEmpty_whenUniversityCreated() {
        //GIVEN
        //WHEN
        University u = new University();

        //THEN
        assertTrue(u.getDepartments().isEmpty());
    }

    @Test
    public void departmentsNotEmpty_whenAddDepartmentToUniversity() {
        //GIVEN
        University u = new University();
        MyDepartment myDepartment = new MyDepartment(DEPARTMENT_NAME_1);

        //WHEN
        u.addDepartment(myDepartment);

        //THEN
        assertFalse(u.getDepartments().isEmpty());
    }

    @Test
    public void departments2Present_whenAdd2DepartmentsTogether() {
        //GIVEN
        University u = new University();

        MyDepartment myDepartment1 = new MyDepartment(DEPARTMENT_NAME_1);
        MyDepartment myDepartment2 = new MyDepartment(DEPARTMENT_NAME_2);

        //WHEN
        u.addDepartment(myDepartment1, myDepartment2);

        //THEN
        assertEquals(2, u.getDepartments().size());
    }

    @Test
    public void departmentsAllPresent_whenAdd2DepartmentsTogether() {
        //GIVEN
        University u = new University();

        MyDepartment myDepartment1 = new MyDepartment(DEPARTMENT_NAME_1);
        MyDepartment myDepartment2 = new MyDepartment(DEPARTMENT_NAME_2);
        MyDepartment myDepartment3 = new MyDepartment(DEPARTMENT_TEF);
        List<MyDepartment> myDepartments =
                new ArrayList<>(Arrays.asList(myDepartment1, myDepartment2, myDepartment3));

        //WHEN
        u.addDepartment(myDepartments);

        //THEN
        assertEquals(3, u.getDepartments().size());
    }

    @Test
    public void departmentName_whenAdd1DepartmentWithName() {
        //GIVEN
        University u = new University();

        MyDepartment myDepartment1 = new MyDepartment(DEPARTMENT_TEF);
        List<MyDepartment> myDepartments = new ArrayList<>(Collections.singletonList(myDepartment1));

        //WHEN
        u.addDepartment(myDepartments);

        //THEN
        assertEquals(DEPARTMENT_TEF, myDepartment1.getName());
    }

    @Test
    public void whenAddDuplicateName() {
        //GIVEN
        MyDepartment d = new MyDepartment(DEPARTMENT_TEF);
        MyDepartment d1 = new MyDepartment(DEPARTMENT_TEF);
        Collection<MyDepartment> s = new HashSet<>();
        s.add(d);

        //WHEN
        s.add(d1);

        //THEN
        s.stream()
                .map(MyDepartment::getId)
                .forEachOrdered(System.out::println);
        System.out.println(s.toString());
        assertEquals(1, s.size());
    }
}