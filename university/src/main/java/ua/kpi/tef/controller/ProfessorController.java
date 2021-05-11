package ua.kpi.tef.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.service.ProfessorService;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ProfessorResponse> addProfessor(@RequestBody Professor professor) {
            if (professor.getName().length() <= 1) {
                throw new ValidationException("Prof name " + professor.getName() + " is too short");
            }
            return ResponseEntity.ok(professorService.addProfessor(professor));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProfessorResponse> getProfessor(@PathVariable(value = "id") Long professorId) {
//        try {
            final ProfessorResponse professor = professorService.getProfessor(professorId);
            return ResponseEntity.ok(professor);
//        } catch (NotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
    }


}
