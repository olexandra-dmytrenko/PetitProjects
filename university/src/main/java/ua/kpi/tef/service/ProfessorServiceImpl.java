package ua.kpi.tef.service;

import com.vaadin.flow.router.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kpi.tef.dto.ProfResponseProfTransfer;
import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.repository.ProfessorRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<ProfessorResponse> getAllProfessors() {
        Iterable<Professor> all = professorRepository.findAll();
        return StreamSupport.stream(all.spliterator(), true)
                .map(ProfResponseProfTransfer::to)
                .collect(Collectors.toList());
    }
}
