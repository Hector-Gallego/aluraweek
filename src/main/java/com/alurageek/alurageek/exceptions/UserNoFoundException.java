package com.alurageek.alurageek.exceptions;

public class UserNoFoundException extends RuntimeException {

    public UserNoFoundException(Long id) {
        super("User whit id: "+id+" not found");
    } 

}
