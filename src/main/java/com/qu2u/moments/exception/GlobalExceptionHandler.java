package com.qu2u.moments.exception;


import com.qu2u.moments.domain.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public Response<String> exceptionHandler(Exception e) {
        return Response.error(500, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<String> exceptionHandler(MethodArgumentNotValidException e) {
        return Response.error(500, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

}
