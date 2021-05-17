package ua.kpi.tef.service;

import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.model.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorResponse addProfessor(Professor professor);

    ProfessorResponse getProfessor(Long id);

    List<ProfessorResponse> getAllProfessors();
}
