package ua.kpi.tef.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import ua.kpi.tef.exception.DepartmentExistsException;

public class University {

    private Collection<MyDepartment> myDepartments;

    public University() {
        myDepartments = new HashSet<>();
    }


    public void addDepartment(MyDepartment... departments) {
        Arrays.stream(departments).forEach(this::tryAddDepartment);
        //this.departments.addAll(Arrays.asList(departments));
    }

    private boolean tryAddDepartment(MyDepartment d) {
        if(true){

        }
        if (isPresent(d)) {
            throw new DepartmentExistsException(d);
        }
        return this.myDepartments.add(d);
    }

    private boolean isPresent(MyDepartment d) {
        return myDepartments.contains(d);
    }

    public void addDepartment(Collection<MyDepartment> myDepartments) {
        this.myDepartments.addAll(myDepartments);
    }

    public Collection<MyDepartment> getDepartments() {
        return myDepartments;
    }
}