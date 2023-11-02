package com.hgvicban.simplequiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgvicban.simplequiz.model.Quiz;
import com.hgvicban.simplequiz.model.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    private final List<String> options = List.of("Robot", "Tea leaf", "Cup of coffee", "Bug");
    private final Quiz firstQuiz = new Quiz("The Java Logo", "What is depicted on the Java logo?", options);
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/quiz")
    public String getQuiz() throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(firstQuiz);
    }

    @PostMapping("/api/quiz")
    public String postAnswer(@RequestParam int answer) throws JsonProcessingException {
        boolean success = answer == 2;

        Response response = new Response(success);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
    }
}
