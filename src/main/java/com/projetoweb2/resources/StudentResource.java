package com.projetoweb2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method =RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody StudentDTO objDto) {
		Student obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method =RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
