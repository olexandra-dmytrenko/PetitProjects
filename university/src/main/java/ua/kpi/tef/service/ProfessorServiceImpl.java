package ua.kpi.tef.service;

import com.vaadin.flow.router.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.dto.ProfResponseProfTransfer;
import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.repository.ProfessorRepository;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public ProfessorResponse addProfessor(Professor professor) {
        return Optional.of(professorRepository.save(professor))
                .map(ProfResponseProfTransfer::to)
                .orElseThrow(() -> new NoSuchElementException("Couldn't create professor"));
    }

    @Override
    public ProfessorResponse getProfessor(Long id) {
        return professorRepository.findById(id)
                .map(ProfResponseProfTransfer::to)
                .orElseThrow(() -> new NotFoundException("Professor with id " + id + " does not exist."));
    }
}
