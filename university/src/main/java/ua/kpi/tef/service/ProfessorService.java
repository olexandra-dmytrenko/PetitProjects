package ua.kpi.tef.service;

import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.model.Professor;

public interface ProfessorService {
    ProfessorResponse addProfessor(Professor professor);

    ProfessorResponse getProfessor(Long id);

}
