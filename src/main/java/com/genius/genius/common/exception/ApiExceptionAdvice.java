package com.genius.genius.common.exception;

import com.genius.genius.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, ApiException e) {
        ApiExceptionEntity apiExceptionEntity = new ApiExceptionEntity(e.getException().getCode(), e.getException().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getException().getStatus(), apiExceptionEntity);
        return ResponseEntity.status(e.getException().getStatus())
                .body(errorResponse);
    }
}