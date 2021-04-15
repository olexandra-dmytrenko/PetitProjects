package ua.kpi.tef.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import ua.kpi.tef.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
//TODO: remove because it exists
//    public Long save(Professor professor);

//    public Professor updateById(Professor professor);

    //    public void delete(long id) ;
    @Query("SELECT p.surname FROM Professor p WHERE p.name = :name")
    public List<Professor> findProfessorByName(final @Param("name") String name);

}
