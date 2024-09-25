package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.QuizDto;
import com.quiz.app.dto.UserAnswers;
import com.quiz.app.service.QuizService;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<QuizDto> createQuiz(@RequestParam String category, @RequestParam int numberOfQuestions,
			@RequestParam String title) {
		return ResponseEntity.ok(quizService.createQuiz(title, category, numberOfQuestions));
	}

	@PostMapping("getQuestions/{id}")
	public ResponseEntity<?> getQuizQuestions(@PathVariable int id) {
		return ResponseEntity.ok(quizService.getQuestionForQuiz(id));
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<?> submitAndGetResult(@PathVariable int id, @RequestBody List<UserAnswers> userAnswers) {
		return ResponseEntity.ok(quizService.calculateResult(id, userAnswers));
	}
}
