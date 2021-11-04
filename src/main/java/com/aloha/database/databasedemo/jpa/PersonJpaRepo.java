package com.aloha.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.aloha.database.databasedemo.entity.Person;

import org.springframework.stereotype.Repository;

/**
 * PersonJpaRepo
 */
@Repository
@Transactional
public class PersonJpaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person delete(int id) {
        Person person = findById(id);
        entityManager.remove(person);
        return person;
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createNamedQuery("find_all_persons", Person.class);
        return query.getResultList();
    }

}