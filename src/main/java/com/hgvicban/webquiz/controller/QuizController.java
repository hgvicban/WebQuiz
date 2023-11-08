package com.hgvicban.webquiz.controller;

import com.hgvicban.webquiz.model.Answer;
import com.hgvicban.webquiz.model.Quiz;
import com.hgvicban.webquiz.model.Response;
import com.hgvicban.webquiz.service.QuizService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/quizzes")
    public Quiz postQuiz(@Valid @RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @PostMapping("/quizzes/{id}/solve")
    public Response postAnswer(
            @PathVariable("id") @Min(0) Long id,
            @Valid @RequestBody Answer quizAnswer
    ) {
        Optional<Quiz> quiz = quizService.findQuizById(id);
        List<Integer> answer = quizAnswer.getAnswer();
        if (quiz.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new Response(quiz.get().checkAnswer(answer));

    }

    @GetMapping("/quizzes/{id}")
    public Optional<Quiz> getQuizById(@PathVariable Long id) {
        Optional<Quiz> quiz = quizService.findQuizById(id);
        if (quiz.isPresent()) {
            return quiz;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes() {
        return quizService.fetchAllQuizzes();
    }
}
