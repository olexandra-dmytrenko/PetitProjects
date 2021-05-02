package ua.kpi.tef.service;

import com.vaadin.flow.router.NotFoundException;

import org.springframework.stereotype.Service;

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
    public Professor getProfessor(Long id) {
        return professorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Professor with id " + id + " does not exist."));
    }
}
