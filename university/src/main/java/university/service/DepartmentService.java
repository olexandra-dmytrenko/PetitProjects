package university.service;

import university.pojo.Professor;

public interface DepartmentService {
    Professor getProfessorBySubject(String subjectName);
}
