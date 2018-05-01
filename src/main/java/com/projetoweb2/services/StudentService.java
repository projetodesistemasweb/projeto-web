package com.projetoweb2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoweb2.DTO.StudentDTO;
import com.projetoweb2.entity.Student;
import com.projetoweb2.repository.StudentRepository;
import com.projetoweb2.services.exception.ObjectNotFoundException;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> findAll(){
		return repo.findAll();
	}
	
	public Student findById(String id) {
		Student student = repo.findOne(id);
		if (student == null) {
			throw new ObjectNotFoundException("Aluno não encontrado");
		}
		return student;
	}
	
	public Student insert(Student obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.delete(id);
	}
	
	public Student fromDTO(StudentDTO objDto) {
		return new Student(objDto.getId(), objDto.getName(), objDto.getAddress());
	}
}
