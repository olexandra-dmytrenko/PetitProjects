package ua.kpi.tef.repository;

import org.springframework.data.repository.CrudRepository;

import ua.kpi.tef.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
//TODO: remove because it exists
//    public Long save(Professor professor);

//    public Professor updateById(Professor professor);

//    public void delete(long id) ;

}
