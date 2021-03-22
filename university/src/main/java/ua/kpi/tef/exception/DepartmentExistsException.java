package ua.kpi.tef.exception;

import ua.kpi.tef.model.MyDepartment;

public class DepartmentExistsException extends RuntimeException {
    public DepartmentExistsException(MyDepartment d) {
        super("Department with name " + d.getName() + " exists");
    }
}