package university.service;

import university.model.Professor;

public interface DepartmentService {
    Professor getProfessorBySubject(String subjectName);
}
