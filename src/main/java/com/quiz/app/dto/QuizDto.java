package com.quiz.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
	private int id;
	private String title;
	private List<QuestionDto> questionDtos;
}
