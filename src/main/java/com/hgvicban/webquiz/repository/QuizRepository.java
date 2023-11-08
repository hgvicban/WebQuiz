package com.hgvicban.webquiz.repository;

import com.hgvicban.webquiz.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
