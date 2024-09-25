package com.quiz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.service.QuestionService;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/getQuestions")
	public ResponseEntity<?> getQuestions() {
		return ResponseEntity.ok(questionService.getQuestions());
	}

	@PostMapping("/createQuestion")
	public ResponseEntity<?> createQuestions(@RequestBody QuestionDto dto) {
		return new ResponseEntity<QuestionDto>(questionService.createQuestions(dto), HttpStatus.CREATED);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category){
		return ResponseEntity.ok(questionService.getQuestionsByCategory(category));
	}

}
