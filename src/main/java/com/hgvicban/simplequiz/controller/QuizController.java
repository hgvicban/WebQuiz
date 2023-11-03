package com.hgvicban.simplequiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hgvicban.simplequiz.model.Quiz;
import com.hgvicban.simplequiz.model.Response;
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

    Map<Integer, Quiz> quizzes = new HashMap<>();

    @PostMapping("/quizzes")
    public Quiz postQuiz(@RequestBody Quiz quiz) throws JsonProcessingException {
        quiz.setId(quizzes.size());
        quizzes.put(quiz.getId(), quiz);
        return quiz;
    }

    @PostMapping("/quizzes/{id}/solve")
    public Response postAnswer(@PathVariable int id, @RequestParam int answer) throws JsonProcessingException {
        if (quizzes.containsKey(id)) return new Response(quizzes.get(id).checkAnswer(answer));

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuizById(@PathVariable int id) throws JsonProcessingException {
        if (quizzes.containsKey(id)) return quizzes.get(id);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes() throws JsonProcessingException {
        return new ArrayList<>(quizzes.values());
    }
}
