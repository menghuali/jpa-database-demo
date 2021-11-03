package com.aloha.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}