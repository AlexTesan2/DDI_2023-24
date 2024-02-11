package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@ExtendWith(MockitoExtension.class) // usaremos mockito, @Mock
@SpringBootTest
class StudentControllerTest {
	@Autowired
	StudentController controller;

	@Mock
	private StudentService service;
	// simula el comportamiento de StudentService sin tener que instanciar un objeto
	// real de esa clase

	@Test
	void testInsertarEstudiante() {
		// given
		Model model = new ExtendedModelMap();
		Student student = new Student();

		when(service.insertStudent(student)).thenReturn(createMockedList());
		// when
		String finPage = controller.insertarEstudiante(student, model);
		// then
		assertEquals("fin", finPage);

		assertNotNull(model.getAttribute("estudiantes"));
		assertInstanceOf(List.class, model.getAttribute("estudiantes"));

		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		assertFalse(lista.isEmpty());

	}

	private List<Student> createMockedList() {
		List<Student> listaPrecreada = new ArrayList<Student>();
		listaPrecreada.add(new Student(1, "ignacio", "bielsa"));
		listaPrecreada.add(new Student(2, "alejandro", "tesan"));
		return listaPrecreada;
	}

	@Test
	void testBuscarEstudiantes() {
		// given
		Model model = new ExtendedModelMap();
		Student studiante = new Student();
		String userInput = "ignacio";
		studiante.setId(1);
		studiante.setNombre(userInput);
		studiante.setApellido("bielsa");
		// when(service.searchStudent(userInput)).thenReturn(createMockedList());
		System.out.println(studiante.getNombre());
		// when
		List<Student> listaestudiantes = service.insertStudent(studiante);
		System.out.println(listaestudiantes);
		String finPage = controller.buscarEstudiantes(userInput, model);

		// then
		assertEquals("fin", finPage);
		assertNotNull(model.getAttribute("estudiantes"));

		assertInstanceOf(List.class, model.getAttribute("estudiantes"));

		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		System.out.println(lista);
		assertFalse(lista.isEmpty());
	}


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		controller = new StudentController();
		controller.setService(service);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
