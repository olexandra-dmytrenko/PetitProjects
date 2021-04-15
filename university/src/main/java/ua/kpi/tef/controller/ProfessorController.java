package ua.kpi.tef.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.service.ProfessorService;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public Professor addProfessor(@RequestParam Professor professor) {
        return professorService.addProfessor(professor);
    }
}
