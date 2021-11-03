package com.aloha.database.databasedemo;

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
		log.info("FOUND BY NAME: {}", personJdbcDao.findByLocation("Toronto"));

		log.info("DELTE BY ID(1003): {}", personJdbcDao.deleteById(1003));
		log.info("DELTE BY Name(Mary): {}", personJdbcDao.deleteByName("Mary"));
		log.info("DELTE BY Location(Toronto): {}", personJdbcDao.deleteByLocation("Toronto"));
	}
}