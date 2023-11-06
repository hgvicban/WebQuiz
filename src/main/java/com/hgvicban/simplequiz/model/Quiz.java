package com.hgvicban.simplequiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Arrays;
import java.util.List;

public class Quiz {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    @Size(min = 2)
    @NotNull
    private List<String> options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int[] answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    public boolean checkAnswer(int[] answer) {
        if (this.answer == null && answer.length == 0) return true;
        else return Arrays.equals(this.answer, answer);
    }
}