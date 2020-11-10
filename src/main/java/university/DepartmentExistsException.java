package university;

public class DepartmentExistsException extends RuntimeException {
    public DepartmentExistsException(Department d) {
        super("Department with name " + d.getName() + " exists");
    }
}