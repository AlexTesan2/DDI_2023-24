package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

	StudentRepository repo;

	@Test
	void testInsertTheSameStudentTwice() {
		Student student = new Student(5, "Fernando", "Del Pino");
		// manera numero 1
		try {
			repo.insert(student);
			repo.insert(student);
			// aqui jamas se deberia de alcanzar
			fail("este codigo no se debe ejecutar");
		} catch (Exception e) {
		}

		// manera numero 2
		assertThrows(DuplicateKeyException.class,
				() -> {
					repo.insert(student);
					repo.insert(student);
				}, "Duplicate entry primary key"
		);
	}

	@Test
	void testInsertStudentShoulbeOk() {
		Student student = new Student(5, "Fernando", "Del Pino");
		assertDoesNotThrow(() -> repo.insert(student));
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
					repo.insert(student);
				}, "Name too long"
		);
	}

	@Test
	void testFindAll() {
		List<Student> lista = repo.findAll();
		assertTrue(lista.isEmpty());
		assertEquals(0, lista.size());

		repo.insert(new Student(3, "Alberto", "Saez"));

		lista = repo.findAll();
		assertFalse(lista.isEmpty());
		assertEquals(1, lista.size());

	}

	@Test
	void testDelete() {
		repo.insert(new Student(3, "Alberto", "Saez"));
		List<Student> lista = repo.findAll();
		assertFalse(lista.isEmpty());
		assertEquals(1, lista.size());

		repo.delete(3);

		lista = repo.findAll();
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
		repo = new StudentRepository();
		assertNotNull(template);
		repo.setJdbcTemplate(template);
		JdbcTestUtils.deleteFromTables(template, "students");
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
