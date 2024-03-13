package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@Service // component, repository esas tres anotaciones hacen que solo se cree un objeto
			// de esta clase y se vaya usando conforme hace falta
public class StudentService {

	@Autowired
	private
	StudentRepository studentRepo;

	public List<Student> insertStudent(Student student) {
		System.out.println("name:" + student.getNombre());
		if (student.getId() == null) {
			studentRepo.save(student);
		} else {
			// si existe un update
			studentRepo.save(student);
		}

		// creamos una lista de estudiantes que gracias al StudentRowMapper nos dará la
		// estructura
		List<Student> lista = (List<Student>) studentRepo.findAll();
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		return lista;
	}



	public Student updateStudentList(Integer id) {
		Student stud = studentRepo.findById(id).get();

		System.out.println(stud.getNombre() + " " + stud.getApellido());
		return stud;
	}

	public List<Student> deleteStudent(Integer id) {
		studentRepo.deleteById(id);

		List<Student> lista = (List<Student>) studentRepo.findAll();
		return lista;
	}


	public List<Student> searchStudent(String userInput) {
		List<Student> lista = studentRepo.findByNombreOrApellido(userInput, userInput);
		for (Student stud : lista) {
			System.out.println(stud.getNombre() + stud.getApellido());
		}
		return lista;
	}

	public Student searchStudentById(Integer id) {
		return studentRepo.findById(id).get();
	}



	public StudentRepository getStudentRepo() {
		return studentRepo;
	}



	public void setStudentRepo(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

}

