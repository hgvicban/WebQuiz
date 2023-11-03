package com.hgvicban.simplequiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgvicban.simplequiz.model.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/api/quiz")
    public String postAnswer(@RequestParam int answer) throws JsonProcessingException {
        boolean success = answer == 2;

        Response response = new Response(success);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
    }
}
