package ua.kpi.tef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.kpi.tef.model.Subject;

//CRUD operations
//https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/
@Repository
//TODO: remove methods that belong to Prof because of generics
public interface SubjectRepository extends JpaRepository<Subject, Long> {
//TODO: find all?
    // public List<Subject> getAllSubjects() ;
}
