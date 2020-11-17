package university;

public class DepartmentExistsException extends RuntimeException {
    public DepartmentExistsException(MyDepartment d) {
        super("Department with name " + d.getName() + " exists");
    }
}