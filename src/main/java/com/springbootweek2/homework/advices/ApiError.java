package com.springbootweek2.homework.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

//@Data
//@Builder
//public class ApiError {
//    private HttpStatus status;
//    private String  message;
//    private List<String> errors;
//}

import java.util.List;
import org.springframework.http.HttpStatus;
import java.util.Objects;

public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    // Constructor (private for builder usage)
    private ApiError(ApiErrorBuilder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.errors = builder.errors;
    }

    // Getters and Setters
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    // toString() method
    @Override
    public String toString() {
        return "ApiError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return status == apiError.status &&
                Objects.equals(message, apiError.message) &&
                Objects.equals(errors, apiError.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, errors);
    }

    // Builder Pattern
    public static class ApiErrorBuilder {
        private HttpStatus status;
        private String message;
        private List<String> errors;

        public ApiErrorBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder errors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }

    // Static method to create builder instance
    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }
}

