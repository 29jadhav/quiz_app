package com.quiz.app.dto.mapper;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.entity.Question;

public class QuestionMapper {

	public static Question mapToQuestion(QuestionDto dto) {
		return new Question(dto.getId(), dto.getQuestion(), dto.getOption1(), dto.getOption2(), dto.getOption3(),
				dto.getOption4(), dto.getCorrectAnswer(), dto.getCategory());
	}

	public static QuestionDto mapToQuestionDto(Question question) {
		return new QuestionDto(question.getId(), question.getQuestion(), question.getOption1(), question.getOption2(),
				question.getOption3(), question.getOption4(), question.getCorrectAnswer(), question.getCategory());
	}

}
