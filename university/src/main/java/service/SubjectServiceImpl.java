package service;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import model.Subject;
import repository.SubjectRepository;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> getSubjects(){
        return subjectRepository.getAllSubjects();
    }
}
