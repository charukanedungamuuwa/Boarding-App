package com.example.backendboadingapp.Response;

public class LoginMesage {
    String message;
    Boolean status;
    int userId;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LoginMesage(String message, Boolean status, int userId) {
        this.message = message;
        this.status = status;
        this.userId = userId;
    }}
