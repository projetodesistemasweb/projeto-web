package com.projetoweb2.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoweb2.DTO.StudentDTO;
import com.projetoweb2.entity.Student;
import com.projetoweb2.services.StudentService;

@RestController
@RequestMapping(value="/students")
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> findAll() {
		List<Student> list = service.findAll();
		List<StudentDTO> listDto = list.stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method =RequestMethod.GET)
	public ResponseEntity<StudentDTO> findById(@PathVariable String id) {
		Student obj = service.findById(id);
		return ResponseEntity.ok().body(new StudentDTO(obj));
	}
}
