package com.quiz.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.dto.mapper.QuestionMapper;
import com.quiz.app.entity.Question;
import com.quiz.app.repository.QuestionRepository;
import com.quiz.app.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public List<QuestionDto> getQuestions() {
		List<Question> questions = questionRepository.findAll();
		return questions.stream().map((question) -> QuestionMapper.mapToQuestionDto(question)).toList();
	}

	@Override
	public QuestionDto createQuestions(QuestionDto questionDto) {
		Question savedQuestion = questionRepository.save(QuestionMapper.mapToQuestion(questionDto));
		return QuestionMapper.mapToQuestionDto(savedQuestion);
	}

	@Override
	public List<QuestionDto> getQuestionsByCategory(String category) {
		List<Question> questions = questionRepository.findByCategory(category);
		return questions.stream().map((question) -> QuestionMapper.mapToQuestionDto(question)).toList();
	}

	@Override
	public List<QuestionDto> findQuestionsByCategory(String category, int numberOfquestions) {
		List<Question> questions = questionRepository.findNumberOfQuestionsByCategory(category, numberOfquestions);
		return questions.stream().map((question) -> QuestionMapper.mapToQuestionDto(question)).toList();
	}

}
