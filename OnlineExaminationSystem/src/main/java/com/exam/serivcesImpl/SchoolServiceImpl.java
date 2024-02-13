package com.exam.serivcesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.SchoolEntity;
import com.exam.repository.SchoolRepository;
import com.exam.services.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	SchoolRepository schoolRepo;

	@Override
	public List<SchoolEntity> fetchAllSchool() {
		
		return schoolRepo.findAll();
	}

	@Override
	public SchoolEntity addSchool(SchoolEntity schoolEntity) {

		return schoolRepo.save(schoolEntity);
	}

	@Override
	public String deleteSchool(int id) {

		if(schoolRepo.findById(id).isPresent()) {
			
			schoolRepo.deleteById(id);
			return "Successfully remove the school";
		}
		return "Sorry no such school found";
	}

	@Override
	public SchoolEntity fetchSchoolById(int id) {
		// TODO Auto-generated method stub
		return schoolRepo.findById(id).orElse(null);
	}
}
