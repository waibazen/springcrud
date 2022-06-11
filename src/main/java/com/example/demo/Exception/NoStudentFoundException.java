package com.example.demo.Exception;

public class NoStudentFoundException extends
RuntimeException {
    private static final long serialVersionUID = 1L;//serialVersionUID is a long value that is used to identify a class of objects when they are serialized.
    private String errorCode;
    private String errorMessage;
    public NoStudentFoundException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public NoStudentFoundException(){

    }
    
}
