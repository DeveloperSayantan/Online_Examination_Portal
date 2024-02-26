package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.QuestionListEntity;
import com.exam.services.QuestionListService;
import com.exam.services.QuestionService;
@RestController
@CrossOrigin()
public class QuestionListController {

	@Autowired
	QuestionListService questionListService;
	
	// find all question Set list
	@GetMapping("/questionList")
	public List<QuestionListEntity> fetchAllQuestions(){
		
		return questionListService.fetchAllQuestionSet();
	}
	// find question Set list by id
	@GetMapping("/questionList/{id}")
	public QuestionListEntity getQuestionById(@PathVariable("id") int id) {
		
		return questionListService.getQuestionById(id);
	}
	// create new question set 
	@PostMapping("/questionList")
    public ResponseEntity<QuestionListEntity> createQuestionSet(@RequestBody QuestionListEntity questionSet) {
        QuestionListEntity savedQuestionSet = questionListService.createQuestionSet(questionSet);
        return new ResponseEntity<>(savedQuestionSet, HttpStatus.CREATED);
    }
}
