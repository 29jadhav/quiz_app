package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.app.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

	List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :count", nativeQuery = true)
	List<Question> findNumberOfQuestionsByCategory(String category, int count);

}
