package university.service;

import java.util.Collections;
import java.util.List;

import repository.SubjectRepository;
import university.pojo.Subject;

public class SubjectServiceImpl implements SubjectService {

    SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getSubjects(){
        return subjectRepository.getAllSubjects();
    }
}
