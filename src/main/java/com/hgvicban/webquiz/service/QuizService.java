package com.hgvicban.webquiz.service;

import com.hgvicban.webquiz.model.Quiz;
import com.hgvicban.webquiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public Quiz saveQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public List<Quiz> fetchAllQuizzes() {
        return (List<Quiz>) repository.findAll();
    }

    public Optional<Quiz> findQuizById(Long id) {
        return repository.findById(id);
    }
}

