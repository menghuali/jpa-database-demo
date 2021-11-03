package com.aloha.database.databasedemo.jdbc;

import java.sql.Types;
import java.util.List;

import com.aloha.database.databasedemo.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from PERSON", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from PERSON where id=?", new Object[] { id },
                new int[] { Types.INTEGER }, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findByName(String name) {
        return jdbcTemplate.query("select * from PERSON where name=?", new Object[] { name },
                new int[] { Types.VARCHAR }, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findByLocation(String location) {
        return jdbcTemplate.query("select * from PERSON where location=?", new Object[] { location },
                new int[] { Types.VARCHAR }, new BeanPropertyRowMapper<Person>(Person.class));
    }

}
