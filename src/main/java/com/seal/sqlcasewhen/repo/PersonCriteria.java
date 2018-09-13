package com.seal.sqlcasewhen.repo;

import com.seal.sqlcasewhen.PersonDTO;
import com.seal.sqlcasewhen.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonCriteria(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPerson() {
        return entityManager.unwrap(Session.class)
                .createCriteria(Person.class)
                .list();
    }
}
