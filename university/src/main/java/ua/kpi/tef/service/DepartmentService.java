package ua.kpi.tef.service;

import ua.kpi.tef.model.Professor;

public interface DepartmentService {
    Professor getProfessorBySubject(String subjectName);
}
