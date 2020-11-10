package university;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class University {

    private Collection<Department> departments;

    public University() {
        departments = new HashSet<>();
    }

    public void addDepartment(Department... departments) {
        Arrays.stream(departments).forEach(this::tryAddDepartment);
        //this.departments.addAll(Arrays.asList(departments));
    }

    private boolean tryAddDepartment(Department d) {
        if (isPresent(d)) {
            throw new DepartmentExistsException(d);
        }
        return departments.add(d);
    }

    private boolean isPresent(Department d) {
        return departments.contains(d);
    }

    public void addDepartment(Collection<Department> departments) {
        this.departments.addAll(departments);
    }

    public Collection<Department> getDepartments() {
        return departments;
    }
}