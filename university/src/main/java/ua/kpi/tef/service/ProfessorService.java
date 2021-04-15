package ua.kpi.tef.service;

import java.util.Optional;

import ua.kpi.tef.model.Professor;

public interface ProfessorService {
    Professor addProfessor(Professor professor);

    Optional<Professor> getProfessor(Long id);

}
