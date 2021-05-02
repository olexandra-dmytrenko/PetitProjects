package ua.kpi.tef.service;

import ua.kpi.tef.model.Professor;

public interface ProfessorService {
    Professor addProfessor(Professor professor);

    Professor getProfessor(Long id);

}
