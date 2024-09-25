package com.quiz.app.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.dto.QuizDto;
import com.quiz.app.dto.UserAnswers;
import com.quiz.app.dto.mapper.QuestionMapper;
import com.quiz.app.dto.mapper.QuizMapper;
import com.quiz.app.dto.wrapper.QuestionDtoWrapper;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;
import com.quiz.app.repository.QuizRepository;
import com.quiz.app.service.QuestionService;
import com.quiz.app.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public QuizDto createQuiz(String title, String category, int numberOfquestions) {
		List<QuestionDto> questionDtos = questionService.findQuestionsByCategory(category, numberOfquestions);
		List<Question> questions = questionDtos.stream().map((questionDto) -> QuestionMapper.mapToQuestion(questionDto))
				.toList();
		Quiz quiz = quizRepository.save(new Quiz(0, title, questions));

		return QuizMapper.convertToQuizDto(quiz);
	}

	@Override
	public List<QuestionDtoWrapper> getQuestionForQuiz(int id) {
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("No quiz present with this id"));
		List<QuestionDtoWrapper> questionWrapprs = quiz
				.getQuestions().stream().map((question) -> new QuestionDtoWrapper(question.getQuestion(),
						question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()))
				.toList();

		return questionWrapprs;
	}

	@Override
	public int calculateResult(int id, List<UserAnswers> answers) {
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("No quiz present with this id"));
		List<Question> questions = quiz.getQuestions();
		Map<Long, String> questionsMap = questions.stream()
				.collect(Collectors.toMap((question) -> question.getId(), (question) -> question.getCorrectAnswer()));
		int rightAnwsers = 0;
		for (UserAnswers answer : answers) {
			String correctAnswer = questionsMap.get(answer.getId());
			if (correctAnswer !=null && (correctAnswer.equals(answer.getUserAnswer()))) {
				rightAnwsers++;
			}

		}
		return rightAnwsers;
	}

}
