package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.student;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.studentjdbcrepository;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

		private Logger logger = LoggerFactory.getLogger(getClass());

		@Autowired
		studentjdbcrepository repository;

		public static void main(String[] args) {
			SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
		}

		@Override
	    public void run(String...args) throws Exception {
			logger.info("estudiante id 10001 -> {}", repository.findById(10001));

	    }
		
		Logger.info("all users 1 -> {}", repository.findall());
		
		logger.info("inserting -> {}", repository.insert(new student(10010 l, "john", "a1234657")));

		logger.info("update 10001 -> {}", repository.update(new student(10001 l, "name-updated", "new-passport")));

		repository.deletebyid(10002 l);

		logger.info("all users 2 -> {}", repository.findall());
		
	}
