package com.exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	 boolean existsByEmail(String email);
	 boolean existsByPhone(Long phone);
	 Optional<Teacher> findByEmailAndPassword(String email, String password);
}
