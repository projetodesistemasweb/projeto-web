package com.projetoweb2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoweb2.entity.Student;
import com.projetoweb2.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> findAll(){
		return repo.findAll();
	}
}
