package ua.kpi.tef.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.service.DepartmentService;

@RequiredArgsConstructor
//@RestController combines @Controller and @ResponseBody,
// two annotations that results in web requests returning data rather than a view.
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/professor")
    public Professor getProfessorBySubject(@RequestParam String subject) {
        return departmentService.getProfessorBySubject(subject);
    }
}
