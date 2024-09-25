package com.quiz.app.dto.mapper;

import java.util.List;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.dto.QuizDto;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;

public class QuizMapper {

	public static Quiz convertToQuiz(QuizDto quizDto) {
		List<Question> questions = quizDto.getQuestionDtos().stream()
				.map((questionDto) -> QuestionMapper.mapToQuestion(questionDto)).toList();
		return new Quiz(quizDto.getId(), quizDto.getTitle(), questions);
	}

	public static QuizDto convertToQuizDto(Quiz quiz) {
		List<QuestionDto> questionDtos = quiz.getQuestions().stream()
				.map((question) -> QuestionMapper.mapToQuestionDto(question)).toList();
		return new QuizDto(quiz.getId(), quiz.getTitle(), questionDtos);
	}

}
