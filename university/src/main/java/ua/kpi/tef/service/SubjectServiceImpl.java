package ua.kpi.tef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import ua.kpi.tef.model.Subject;
import ua.kpi.tef.repository.SubjectRepository;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }
}
