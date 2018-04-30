package com.projetoweb2.DTO;

import java.io.Serializable;

import com.projetoweb2.entity.Student;

public class StudentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String address;
	
	public StudentDTO() {
		
	}

	public StudentDTO(Student obj) {
		id = obj.getId();
		name = obj.getName();
		address = obj.getAddress();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
