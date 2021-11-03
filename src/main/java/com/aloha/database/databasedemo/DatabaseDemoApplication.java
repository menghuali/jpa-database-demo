package com.aloha.database.databasedemo;

import java.util.Date;

import com.aloha.database.databasedemo.entity.Person;
import com.aloha.database.databasedemo.jdbc.PersonJdbcDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("FIND ALL: {}", personJdbcDao.findAll());
		log.info("FOUND BY ID: {}", personJdbcDao.findById(1001));
		log.info("FOUND BY NAME: {}", personJdbcDao.findByName("Mary"));
		log.info("FOUND BY LOCATION: {}", personJdbcDao.findByLocation("Toronto"));

		log.info("DELTE BY ID(1003): {}", personJdbcDao.deleteById(1003));
		log.info("DELTE BY NAME(Mary): {}", personJdbcDao.deleteByName("Mary"));
		log.info("DELTE BY LOCATION(Toronto): {}", personJdbcDao.deleteByLocation("Toronto"));

		log.info("INSERT(1100): {}", personJdbcDao
				.insert(Person.builder().id(1100).name("James").location("Winsor").birthDate(new Date()).build()));

		log.info("UPDATE(1100): {}", personJdbcDao
				.update(Person.builder().id(1100).name("James").location("Chicago").birthDate(new Date()).build()));
	}
}