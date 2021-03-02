package university.controller;

import org.springframework.stereotype.Controller;

import university.pojo.Professor;
import university.service.DepartmentService;

@Controller
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Professor getProfessorBySubject(String subject) {
        return departmentService.getProfessorBySubject(subject);
    }
}
