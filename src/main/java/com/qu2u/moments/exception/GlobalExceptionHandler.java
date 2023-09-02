package com.qu2u.moments.exception;


import com.qu2u.moments.domain.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public Response<String> exceptionHandler(Exception e) {
        return Response.error(500, e.getMessage());
    }
}
