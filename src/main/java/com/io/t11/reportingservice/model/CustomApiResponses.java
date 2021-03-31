package com.io.t11.reportingservice.model;

public class CustomApiResponses {
    private Integer status;
    private String message;

    public CustomApiResponses(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomApiResponses{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
