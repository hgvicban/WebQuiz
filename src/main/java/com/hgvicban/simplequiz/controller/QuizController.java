package com.hgvicban.simplequiz.controller;

import com.hgvicban.simplequiz.model.Answer;
import com.hgvicban.simplequiz.model.Quiz;
import com.hgvicban.simplequiz.model.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QuizController {

    private final Map<Integer, Quiz> quizzes = new HashMap<>();

    @PostMapping("/quizzes")
    public Quiz postQuiz(@Valid @RequestBody Quiz quiz) {
        quiz.setId(quizzes.size());
        quizzes.put(quiz.getId(), quiz);
        return quiz;
    }

    @PostMapping("/quizzes/{id}/solve")
    public Response postAnswer(
            @PathVariable("id") @Min(0) int id,
            @Valid @RequestBody Answer answer) {
        if (quizzes.containsKey(id)) {
            return new Response(quizzes.get(id).checkAnswer(answer.getAnswer()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuizById(@PathVariable int id) {
        if (quizzes.containsKey(id)) return quizzes.get(id);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes() {
        return new ArrayList<>(quizzes.values());
    }
}
