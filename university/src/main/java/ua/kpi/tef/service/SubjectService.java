package ua.kpi.tef.service;

import java.util.List;

import ua.kpi.tef.model.Subject;

public interface SubjectService {
    List<Subject> getSubjects();

    Subject addSubject(Subject subject);

}
