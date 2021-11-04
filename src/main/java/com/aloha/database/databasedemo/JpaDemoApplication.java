package com.aloha.database.databasedemo;

import java.util.Date;

import com.aloha.database.databasedemo.entity.Person;
import com.aloha.database.databasedemo.jpa.PersonJpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	@Autowired
	private PersonJpaRepo personJpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("FIND ALL: {}", personJpaRepo.findAll());
		log.info("FOUND BY ID: {}", personJpaRepo.findById(1001));
		// log.info("FOUND BY NAME: {}", personJdbcDao.findByName("Mary"));
		// log.info("FOUND BY LOCATION: {}", personJdbcDao.findByLocation("Toronto"));

		// log.info("DELTE BY ID(1003): {}", personJdbcDao.deleteById(1003));
		// log.info("DELTE BY NAME(Mary): {}", personJdbcDao.deleteByName("Mary"));
		// log.info("DELTE BY LOCATION(Toronto): {}",
		// personJdbcDao.deleteByLocation("Toronto"));

		log.info("UPDATE-1: {}",
				personJpaRepo.update(Person.builder().name("James").location("Winsor").birthDate(new Date()).build()));
		log.info("UPDATE-2: {}",
				personJpaRepo.update(Person.builder().name("Jordan").location("Chicago").birthDate(new Date()).build()));

		log.info("DELTE(1001): {}", personJpaRepo.delete(1001));
	}
}