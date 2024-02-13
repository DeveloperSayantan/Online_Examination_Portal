package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.SchoolEntity;
import com.exam.services.SchoolService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
	@GetMapping("/schools")
	public List<SchoolEntity> fetchAllSchools(){
		
		return schoolService.fetchAllSchool();
	}
	@GetMapping("/schools/{id}")
    public SchoolEntity fetchSchoolById(@PathVariable int id) {
        return schoolService.fetchSchoolById(id);
    }

}
