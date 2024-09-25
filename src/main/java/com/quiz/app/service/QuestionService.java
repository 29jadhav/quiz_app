package com.quiz.app.service;

import java.util.List;

import com.quiz.app.dto.QuestionDto;

public interface QuestionService {

	List<QuestionDto> getQuestions();

	List<QuestionDto> getQuestionsByCategory(String category);

	QuestionDto createQuestions(QuestionDto questionDto);

	List<QuestionDto> findQuestionsByCategory(String category, int numberOfquestions);

}
