package com.springbootweek2.homework.advices;

import com.springbootweek2.homework.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Custom Exception
 @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse<?>> handleDepartmentNotFound(ResourceNotFound exception) {
     ApiError apiError = ApiError.builder()
             .message(exception.getMessage())
             .status(HttpStatus.NOT_FOUND)
             .build();
     return buildErrorResponse(apiError);
 }

    private ResponseEntity<ApiResponse<?>> buildErrorResponse(ApiError apiError) {
       return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception)
    {
        List<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .message("Input Validation Failed")
                .status(HttpStatus.BAD_REQUEST)
                .errors(errors)
                .build();
        return buildErrorResponse(apiError);
    }

    //Global Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception)
    {
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return buildErrorResponse(apiError);
    }

}
