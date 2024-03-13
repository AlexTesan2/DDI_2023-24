package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest 
@AutoConfigureMockMvc
class StudentControllerTest2 {

//	@Autowired
//	StudentController controller;

	@Autowired
	MockMvc mockmvc;

	@Test
	void testInsertStudentForm() {
		MockHttpServletRequestBuilder requestBuilder = get("/insertStudent")
														.queryParam("nombre", "Fernando")
														.queryParam("apellido", "Del Pino");
		
		try {
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("fin", modelAndView.getViewName());
			assertNotNull(modelAndView.getModel().get("estudiantes"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("No deberia producirse una excepcion");
		}
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
