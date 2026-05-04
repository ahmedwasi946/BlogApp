package com.example.blogApp.exception;


import jakarta.annotation.Resources;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BlogAppGlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse resourcesNotFound(
            ResourceNotFoundException resourceNotFoundException,
                        HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(resourceNotFoundException.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();
        return errorResponse;
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException exception,
//                                                        HttpServletRequest request){
//        Map<String , String> errors = new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(  error -> {
//            errors.put(errors.getField, error.getDefaultMessage());
//        });
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .timestamp(LocalDateTime.now())
//                .message("Fields Error")
//                .statusCode(HttpStatus.BAD_REQUEST.value())
//                .path(request)
//                .build();
//        return errorResponse;

        @ExceptionHandler(UserNotFoundException.class)
                public ErrorResponse userNotFound(UserNotFoundException exception,
                                        HttpServletRequest request){
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message(exception.getMessage())
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .path(request.getRequestURI())
                    .build();
            return errorResponse;
        }
        // Helper Method
//        public static ErrorResponse helperMethod(RuntimeException exception, HttpServletRequest request){
//            ErrorResponse errorResponse = ErrorResponse.builder()
//                    .timestamp(LocalDateTime.now())
//                    .message(exception.getMessage())
//                    .statusCode(HttpStatus.Not_Found.value())
//                    .path(request.getRequestURL())
//                    .build();
//
//            return errorResponse;
//        }

        @ExceptionHandler(Exception.class)
                public ErrorResponse exceptionError(HttpServletRequest request){
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message("Something went wrong... from server side..")
                    .statusCode(HttpStatus.BAD_GATEWAY.value())
                    .path(request.getRequestURI())
                    .build();
                return errorResponse;
        }
    }

