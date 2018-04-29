package com.projetoweb2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoweb2.entity.Student;
import com.projetoweb2.services.StudentService;

@RestController
@RequestMapping(value="/students")
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Student>> findAll() {
		List<Student> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}