package service;

import model.Professor;

public interface DepartmentService {
    Professor getProfessorBySubject(String subjectName);
}
