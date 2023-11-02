package com.hgvicban.simplequiz.model;

public class Response {
    private boolean success;
    private String feedback;

    public Response(boolean success) {
        this.success = success;
        this.feedback = success ?
                "Congratulations, you're right!" :
                "Wrong answer! Please, try again.";
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
