package com.alurageek.alurageek.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(UserNoFoundException.class)
    public ResponseEntity<Object> handlerUserNotFoundException(UserNoFoundException e){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> execptionError2(MethodArgumentTypeMismatchException e){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", e.getMessage());
        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
