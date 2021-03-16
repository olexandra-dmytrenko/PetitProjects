package controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import model.Professor;
import service.DepartmentService;

@RequiredArgsConstructor
@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    public Professor getProfessorBySubject(String subject) {
        return departmentService.getProfessorBySubject(subject);
    }
}
