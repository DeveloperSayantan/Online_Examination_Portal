package com.exam.services;

import java.util.List;
import java.util.Optional;

import com.exam.entity.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeachers();

	Teacher getTeacherById(Long id);

	Teacher saveTeacher(Teacher teacher);

	void deleteTeacher(Long id);

	boolean isEmailExists(String email);

	boolean isPhoneExists(Long newPhone);

	Optional<Teacher> login(String email, String password);

}
