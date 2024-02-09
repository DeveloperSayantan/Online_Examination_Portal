package com.exam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Teacher;
import com.exam.services.TeacherService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
/******************** Read Data *************************************************/
	 @GetMapping("/teachers")
	    public ResponseEntity<List<Teacher>> getAllTeachers() {
	        List<Teacher> teachers = teacherService.getAllTeachers();
	        return new ResponseEntity<>(teachers, HttpStatus.OK);
	    }
/******************** Read Data By Id *************************************************/
	 @GetMapping("/teachers/{id}")
	    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
	        Teacher teacher = teacherService.getTeacherById(id);
	        if (teacher != null) {
	            return new ResponseEntity<>(teacher, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
/******************** Write Data*************************************************/
	 @PostMapping("/teachers")
	    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
	        Teacher createdTeacher = teacherService.saveTeacher(teacher);
	        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
	    }
/******************** Update Data *************************************************/
	 @PutMapping("/teachers/{id}")
	    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
	        Teacher teacher = teacherService.getTeacherById(id);
	        if (teacher == null) {
	            return ResponseEntity.notFound().build();
	        }
	        teacher.setName(teacherDetails.getName());
	        teacher.setEmail(teacherDetails.getEmail());
	        teacher.setPhone(teacherDetails.getPhone());
	        teacher.setPassword(teacherDetails.getPassword());
	        teacher.setSchool_id(teacherDetails.getSchool_id());
	        teacher.setBoard_id(teacherDetails.getBoard_id());
	        Teacher updatedTeacher = teacherService.saveTeacher(teacher);
	        return ResponseEntity.ok(updatedTeacher);
	    }
/******************** Delete Data *************************************************/
	 @DeleteMapping("/teachers/{id}")
	    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
	        Teacher teacher = teacherService.getTeacherById(id);
	        if (teacher == null) {
	            return ResponseEntity.notFound().build();
	        }
	        teacherService.deleteTeacher(id);
	        return ResponseEntity.noContent().build();
	    }
/******************** Teacher Registration *************************************************/
	 @PostMapping("/teachers/register")
	    public ResponseEntity<Object> registerTeacher(@Valid @RequestBody Teacher teacher) {
	        if (teacherService.isEmailExists(teacher.getEmail())) {
	            return ResponseEntity.badRequest().body("Email already exists");
	        }
	        if (teacherService.isPhoneExists(teacher.getPhone())) {
	            return ResponseEntity.badRequest().body("Phone already exists");
	        }
	        Teacher registeredTeacher = teacherService.saveTeacher(teacher);
	        return ResponseEntity.ok("Teacher registered successfully with ID: " + registeredTeacher.getTid());
	    }
/******************** Teacher Login *************************************************/
	    @PostMapping("/teachers/login")
	    public ResponseEntity<Object> loginTeacher(@RequestBody Teacher loginRequest) {
	        Optional<Teacher> teacher = teacherService.login(loginRequest.getEmail(), loginRequest.getPassword());
	        if (teacher.isPresent()) {
	            return ResponseEntity.ok(teacher.get());
	        } else {
	            return ResponseEntity.badRequest().body("Invalid email or password");
	        }
	    }

}
