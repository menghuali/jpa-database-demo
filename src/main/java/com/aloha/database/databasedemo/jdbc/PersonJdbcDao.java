package com.aloha.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.aloha.database.databasedemo.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Sample of Spring Data JDBC
 */
@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Sample of custom RowMapper
     */
    private class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNumber) throws SQLException {
            return Person.builder().id(rs.getInt("id")).name(rs.getString("name")).location(rs.getString("location"))
                    .birthDate(rs.getTimestamp("birth_date")).build();
        }

    }

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
                new int[] { Types.VARCHAR }, new PersonRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from PERSON where id=?", new Object[] { id });
    }

    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from PERSON where name=?", new Object[] { name });
    }

    public Object deleteByLocation(String location) {
        return jdbcTemplate.update("delete from PERSON where location=?", new Object[] { location });
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?, ?, ?, ?)",
                new Object[] { person.getId(), person.getName(), person.getLocation(), person.getBirthDate() },
                new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP });
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?;",
                new Object[] { person.getName(), person.getLocation(), person.getBirthDate(), person.getId() },
                new int[] { Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.INTEGER });
    }

}
