package university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DepartmentTest {

    private static final String DEPARTMENT_NAME_1 = "Dep1";
    private static final String DEPARTMENT_TEF = "TEF";

    @Before
    public void setUp() {
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
        Department department = new Department(DEPARTMENT_NAME_1);

        //WHEN
        u.addDepartment(department);

        //THEN
        assertFalse(u.getDepartments().isEmpty());
    }

    @Test
    public void departments2Present_whenAdd2DepartmentsTogether() {
        //GIVEN
        University u = new University();

        Department department1 = new Department(DEPARTMENT_NAME_1);
        Department department2 = new Department(DEPARTMENT_NAME_1);

        //WHEN
        u.addDepartment(department1, department2);

        //THEN
        assertEquals(2, u.getDepartments().size());
    }

    @Test
    public void departmentsAllPresent_whenAdd2DepartmentsTogether() {
        //GIVEN
        University u = new University();

        Department department1 = new Department(DEPARTMENT_NAME_1);
        Department department2 = new Department(DEPARTMENT_NAME_1);
        Department department3 = new Department(DEPARTMENT_NAME_1);
        List<Department> departments =
                new ArrayList<>(Arrays.asList(department1, department2, department3));

        //WHEN
        u.addDepartment(departments);

        //THEN
        assertEquals(3, u.getDepartments().size());
    }

    @Test
    public void departmentName_whenAdd1DepartmentWithName() {
        //GIVEN
        University u = new University();

        Department department1 = new Department(DEPARTMENT_TEF);
        List<Department> departments = new ArrayList<>(Collections.singletonList(department1));

        //WHEN
        u.addDepartment(departments);

        //THEN
        assertEquals(DEPARTMENT_TEF, department1.getName());
    }

    @Test
    public void whenAddDuplicateName() {
        //GIVEN
        Department d = new Department(DEPARTMENT_TEF);
        Department d1 = new Department(DEPARTMENT_TEF);
        Collection<Department> s = new HashSet<>();
        s.add(d);

        //WHEN
        s.add(d1);

        //THEN
        s.stream()
                .map(Department::getId)
                .forEachOrdered(System.out::println);
        System.out.println(s.toString());
        assertEquals(1, s.size());
    }
}