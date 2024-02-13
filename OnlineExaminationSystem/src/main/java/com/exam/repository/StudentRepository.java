package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	StudentEntity findByEmail(String email);
	
	public StudentEntity findByEmailAndPassword(String email, String password);
	
	boolean existsByEmail(String email);
	
	boolean existsByPhone(Long phone);
	
//	@Query("SELECT s FROM StudentEntity s WHERE s.school_id.sid = :schoolId")
//    List<StudentEntity> findBySchoolId(int schoolId);
	List<StudentEntity> findByCls(String cls);
}
