package com.springbootweek2.homework.advices;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;



public class ApiResponse<T> {
    @JsonFormat(pattern = "hh-mm-ss dd-MM-yyyy")
    private LocalDateTime timeStamps;
    private T data;
    private ApiError errors;

    public ApiResponse() {
        this.timeStamps = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError errors) {
        this();
        this.errors = errors;
    }

    public LocalDateTime getTimeStamps() {
        return timeStamps;
    }

    public void setTimeStamps(LocalDateTime timeStamps) {
        this.timeStamps = timeStamps;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getErrors() {
        return errors;
    }

    public void setErrors(ApiError errors) {
        this.errors = errors;
    }
}
