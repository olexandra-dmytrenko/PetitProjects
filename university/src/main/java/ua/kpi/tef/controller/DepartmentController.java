package ua.kpi.tef.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.service.DepartmentService;

@RequiredArgsConstructor
@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    public Professor getProfessorBySubject(String subject) {
        return departmentService.getProfessorBySubject(subject);
    }
}
