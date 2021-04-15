package ua.kpi.tef.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.model.Subject;
import ua.kpi.tef.service.SubjectService;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public Subject addSubject(@RequestParam Subject subject) {
        return subjectService.addSubject(subject);
    }
}
