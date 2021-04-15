package ua.kpi.tef.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.repository.ProfessorRepository;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> getProfessor(Long id) {
        return professorRepository.findById(id);
    }
}
