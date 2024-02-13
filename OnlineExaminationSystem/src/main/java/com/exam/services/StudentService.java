package com.exam.services;

import java.util.List;
import java.util.Optional;

import com.exam.entity.StudentEntity;

import jakarta.validation.Valid;

public interface StudentService {

	StudentEntity addStudent(StudentEntity studentEntity); //Adding Students
	
	List<StudentEntity> fetchAllStudentEntities(); //Fetching all Students

	StudentEntity getStudentById(int id); //Fetching Students by there ID
	
	Optional<StudentEntity> login(StudentEntity inputCsmailpass); //Login email and password

	boolean isEmailExists(String email); //Checking email already exists or not

	boolean isPhoneExists(Long phone);	//Checking phone already exists or not

	StudentEntity updateStudent(int id, StudentEntity updatedStudent);

	List<StudentEntity> getStudentsByClass(String cls);
}
