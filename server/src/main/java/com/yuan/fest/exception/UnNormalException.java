package com.yuan.fest.exception;

public class UnNormalException extends RuntimeException {

    String message;

    public UnNormalException(String message) {
        this.message = message;
    }
    public UnNormalException() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
