package ua.kpi.tef.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }

    @PostMapping("/test")
    public void addProfessor1(@RequestBody int professor) {
        System.out.println(professor);
    }

    @GetMapping
    @ResponseBody
    public Professor getProfessor(@RequestParam Long professorId) {

        return professorService.getProfessor(professorId);
    }


}
