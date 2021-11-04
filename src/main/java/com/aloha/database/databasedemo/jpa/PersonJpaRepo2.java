package com.aloha.database.databasedemo.jpa;

import com.aloha.database.databasedemo.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepo2 extends JpaRepository<Person, Integer> {
}
