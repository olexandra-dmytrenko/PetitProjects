package ua.kpi.tef.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.service.ProfessorService;

import javax.validation.ValidationException;
import java.util.Collection;
import java.util.List;

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
        final ProfessorResponse professor = professorService.getProfessor(professorId);
        return ResponseEntity.ok(professor);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Collection<ProfessorResponse>> getAllProfessors()    {
        final List<ProfessorResponse> professors = professorService.getAllProfessors();
        return ResponseEntity.ok(professors);
    }


}
