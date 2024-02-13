package com.exam.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.exam.entity.StudentEntity;
import com.exam.services.StudentService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<String> addStudent(@RequestBody @Valid StudentEntity studentEntity) {
		
		if (studentService.isEmailExists(studentEntity.getEmail())) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
            
        }
		
		if (studentService.isPhoneExists( studentEntity.getPhone())) {
            return new ResponseEntity<>("Phone already exists", HttpStatus.BAD_REQUEST);
            
        }
        
		studentService.addStudent(studentEntity);
        return new ResponseEntity<>("Account Created!!", HttpStatus.OK);
		
	}
	
	@GetMapping("/students")
	public List<StudentEntity> fetchAllStudent(){
		
		return studentService.fetchAllStudentEntities();
	}
	
	@GetMapping("/students/{id}")
	public StudentEntity getStudentById(@PathVariable("id") int id) {
		
		return studentService.getStudentById(id);
	}

	@GetMapping("/students/class/{cls}")
	public List<StudentEntity> getStudentsByClass(@PathVariable String cls) {
	        return studentService.getStudentsByClass(cls);
	    }
	
	//Login by email id and password
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody StudentEntity inputCsmailpass) {
		Optional<StudentEntity> student = studentService.login(inputCsmailpass);			
			if (student.isPresent()) {
			       return ResponseEntity.ok(student.get());
			} else {
			      return ResponseEntity.badRequest().body("Invalid email or password");
			}
	}
	
	// UPdate profile
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable("id") int id, @RequestBody @Valid StudentEntity updatedStudent) {
	    StudentEntity updatedEntity = studentService.updateStudent(id, updatedStudent);

	    if (updatedEntity != null) {
	        return ResponseEntity.ok(updatedEntity);
	    } else {
	        return ResponseEntity.notFound().build(); // You can customize the response as needed
	    }
	}

}
