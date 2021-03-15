package university.service;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import repository.SubjectRepository;
import university.model.Subject;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> getSubjects(){
        return subjectRepository.getAllSubjects();
    }
}
