package com.hgvicban.webquiz.model;

public class Response {

    public static final String CONGRATULATIONS = "Congratulations, you're right!";
    public static final String WRONG_ANSWER = "Wrong answer! Please, try again.";

    private boolean success;
    private String feedback;

    public Response(boolean success) {
        this.success = success;
        this.feedback = success ? CONGRATULATIONS : WRONG_ANSWER;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
