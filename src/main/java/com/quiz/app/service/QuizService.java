package com.quiz.app.service;

import java.util.List;

import com.quiz.app.dto.QuizDto;
import com.quiz.app.dto.UserAnswers;
import com.quiz.app.dto.wrapper.QuestionDtoWrapper;

public interface QuizService {

	QuizDto createQuiz(String title, String category, int numberOfquestions);
	
	List<QuestionDtoWrapper> getQuestionForQuiz(int id);
	
	int calculateResult(int id, List<UserAnswers> answers);

}
