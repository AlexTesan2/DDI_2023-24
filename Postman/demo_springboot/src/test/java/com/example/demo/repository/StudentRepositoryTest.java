package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.example.demo.model.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	JdbcTemplate template;

	@Autowired
	StudentRepository repo;

	@Test
	void testInsertTheSameStudentTwice() {
		Student student = new Student(5, "Fernando", "Del Pino");
		// manera numero 1
		try {
			repo.save(student);
			repo.save(student);
			// aqui jamas se deberia de alcanzar
			fail("este codigo no se debe ejecutar");
		} catch (Exception e) {
		}

		// manera numero 2
		assertThrows(DuplicateKeyException.class,
				() -> {
					repo.save(student);
					repo.save(student);
				}, "Duplicate entry primary key"
		);
	}

	@Test
	void testInsertStudentShoulbeOk() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.save(student));
	}

	@Test
	void testInsertStudentNameIsTooLong() {
		Student student = new Student(5, "Fernando Fernando " + "Fernando Fernando Fernando "
				+ "Fernando Fernando Fernando Fernando Fernando " + "Fernando Fernando Fernando Fernando Fernando "
				+ "Fernando Fernando Fernando Fernando Fernando " + "Fernando Fernando Fernando Fernando Fernando "
				+ "Fernando Fernando Fernando Fernando Fernando " + "Fernando Fernando Fernando Fernando Fernando "
				+ "Fernando Fernando Fernando Fernando Fernando " + "Fernando Fernando Fernando", "Del Pino");
		assertThrows(DataIntegrityViolationException.class,
				() -> {
					repo.save(student);
				}, "Name too long"
		);
	}

	@Test
	void testFindAll() {
		List<Student> lista = (List<Student>) repo.findAll();
		assertTrue(lista.isEmpty());
		assertEquals(0, lista.size());

		repo.save(new Student(3, "Alberto", "Saez"));

		lista = (List<Student>) repo.findAll();
		assertFalse(lista.isEmpty());
		assertEquals(1, lista.size());

	}

	@Test
	void testDelete() {
		repo.save(new Student(3, "Alberto", "Saez"));
		List<Student> lista = (List<Student>) repo.findAll();
		assertFalse(lista.isEmpty());
		assertEquals(1, lista.size());

		repo.deleteById(3);

		lista = (List<Student>) repo.findAll();
		assertTrue(lista.isEmpty());
		assertEquals(0, lista.size());

	}

	// public animmmous() {
//		return     repo.insert(student);
//		}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		JdbcTestUtils.deleteFromTables(template, "students");
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
