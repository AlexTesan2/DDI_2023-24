package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

	StudentService service;

	@Spy
	StudentRepository repository;

	@Test
	void testInsertStudentWhenStudentHasNotId() {
		// Given
		Student student = new Student();
		student.setNombre("Alejandro");
		student.setApellido("Tesán");
		student.setId(null);
		doNothing().when(repository).save(student);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student);
		doReturn(studentList).when(repository).findAll(); // usar esto con los @spy
		// when(repository.findAll()).thenReturn(studentList); // usar esto con los @mock
		
		//When
		List<Student> listStudents = service.insertStudent(student);
		// Then
		assertNotNull(listStudents);
		assertFalse(listStudents.isEmpty());

		verify(repository, times(1)).save(student);
		verify(repository, times(0)).save(student);
		verify(repository, times(1)).findAll();

	}

	@Test
	void testInsertStudentWhenStudentHasId() {
		// Given
		Student student = new Student();
		student.setNombre("Alejandro");
		student.setApellido("Tesán");
		student.setId(3);
		doNothing().when(repository).save(student);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student);
		doReturn(studentList).when(repository).findAll(); // usar esto con los @spy
		// when(repository.findAll()).thenReturn(studentList); // usar esto con los
		// @mock

		// When
		List<Student> listStudents = service.insertStudent(student);
		// Then
		assertNotNull(listStudents);
		assertFalse(listStudents.isEmpty());

		verify(repository, times(0)).save(student);
		verify(repository, times(1)).save(student);
		verify(repository, times(1)).findAll();

	}


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		service = new StudentService();
		service.setStudentRepo(repository);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
