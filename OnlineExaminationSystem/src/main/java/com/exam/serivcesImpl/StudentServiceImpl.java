package com.exam.serivcesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.StudentEntity;
import com.exam.repository.StudentRepository;
import com.exam.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public StudentEntity addStudent(StudentEntity studentEntity) {
		
		return studentRepository.save(studentEntity);
	}
	
	@Override
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		return studentRepository.existsByEmail(email);
	}
	
	@Override
	public boolean isPhoneExists(Long phone) {
		// TODO Auto-generated method stub;
		return studentRepository.existsByPhone(phone);
	}

	@Override
	public List<StudentEntity> fetchAllStudentEntities() {
		
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity getStudentById(int id) {
		
		Optional<StudentEntity> studentOps = studentRepository.findById(id);
		
		if(studentOps.isPresent()) {
			
			return studentOps.get();
		}

		return null;
	}
	
	//login
	@Override
	public Optional<StudentEntity> login(StudentEntity inputCsmailpass) {
		
		return Optional.ofNullable(studentRepository.findByEmailAndPassword(inputCsmailpass.getEmail(),inputCsmailpass.getPassword()));
	}

	
	@Override
	public StudentEntity updateStudent(int id, StudentEntity updatedStudent) {
	    Optional<StudentEntity> existingStudent = studentRepository.findById(id);

	    if (existingStudent.isPresent()) {
	        StudentEntity currentStudent = existingStudent.get();
	        // Update fields as needed
	        currentStudent.setName(updatedStudent.getName());
	        currentStudent.setCls(updatedStudent.getCls());
	        currentStudent.setEmail(updatedStudent.getEmail());
	        currentStudent.setPhone(updatedStudent.getPhone());
//	        currentStudent.setSchool_id(updatedStudent.getSchool_id());
//	        currentStudent.setBoard_id(updatedStudent.getBoard_id());
//	        currentStudent.setPassword(updatedStudent.getPassword());

	        return studentRepository.save(currentStudent);
	    }

	    return null; // Handle the case where the student with the given ID is not found
	}

	@Override
	public List<StudentEntity> getStudentsByClass(String cls) {
		// TODO Auto-generated method stub
		return studentRepository.findByCls(cls);
	}

	

}
