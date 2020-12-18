package university.api;

import university.pojo.Professor;
import university.service.DepartmentService;

public class DepartmentApi {
    private DepartmentService departmentService;

    public Professor getProfessorBySubject(String subject) {
        return departmentService.getProfessorBySubject(subject);
    }
}
