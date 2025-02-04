package com.springbootweek2.homework.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String message) {
        super(message);
    }
}
