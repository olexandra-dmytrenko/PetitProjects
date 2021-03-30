package ua.kpi.tef.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ua.kpi.tef.model.MyDepartment;

//@Repository
//setting the readOnly-flag (at the class level) for findByCustomer(…). This causes some performance optimizations inside the persistence provider as well as on the database level.
@Transactional(readOnly = true)
public class DepartmentRepository {

    // @PersistenceContext
    private EntityManager em;

    @Transactional
    public MyDepartment save(MyDepartment account) {

        if (account.getId() == null) {
            em.persist(account);
            return account;
        } else {
            return em.merge(account);
        }
    }

    public List<MyDepartment> findByName(String name) {

        TypedQuery query = em.createQuery("select d from MyDepartment d where d.name = ?1", MyDepartment.class);
        query.setParameter(1, name);

        return query.getResultList();
    }

}
