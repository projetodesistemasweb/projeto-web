package com.projetoweb2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoweb2.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

	List<Student> findAll();

}
