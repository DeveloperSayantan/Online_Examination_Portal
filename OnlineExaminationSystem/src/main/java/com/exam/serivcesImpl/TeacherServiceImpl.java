package com.exam.serivcesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Teacher;
import com.exam.repository.TeacherRepository;
import com.exam.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		// TODO Auto-generated method stub
		Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
	       return optionalTeacher.orElse(null); 
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		 return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
		
	}

	@Override
	public boolean isEmailExists(String email) {
		
		return teacherRepository.existsByEmail(email);
	}

	@Override
	public boolean isPhoneExists(Long phone) {
		
		return teacherRepository.existsByPhone(phone);
	}

	@Override
	public Optional<Teacher> login(String email, String password) {
		
		return teacherRepository.findByEmailAndPassword(email, password);
	}


}
