package university.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import university.model.Professor;
import university.service.DepartmentService;

@RequiredArgsConstructor
@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    public Professor getProfessorBySubject(String subject) {
        return departmentService.getProfessorBySubject(subject);
    }
}
