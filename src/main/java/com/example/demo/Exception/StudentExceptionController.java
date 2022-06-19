package com.example.demo.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice//global exception handler
public class StudentExceptionController extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        
              return new ResponseEntity<String>("no such Student Id found ", HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
       
        return new ResponseEntity<Object>("Method not supported", HttpStatus.METHOD_NOT_ALLOWED);
    }
     @ExceptionHandler(NoSuchFieldError.class)
    public ResponseEntity<String> handleNoSuchFieldError(NoSuchFieldError ex) {
        
              return new ResponseEntity<String>("no such Field found ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumberFormatException.class )
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException ex) {
        
              return new ResponseEntity<String>("Number format exception", HttpStatus.NOT_FOUND);
       
    }
}
    
   