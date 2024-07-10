package com.umpar.config;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.umpar.exception.ApiResponse;
import com.umpar.exception.CnpjIndisponivelException;
import com.umpar.exception.EmailIndisponivelException;
import com.umpar.exception.InvalidParameterException;
import com.umpar.exception.NotFoundException;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = EmailIndisponivelException.class)
    public ResponseEntity<Object> handleValidationException(EmailIndisponivelException ex) {
        ApiResponse<?> errorResponse = new ApiResponse<>(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleValidationException(NotFoundException ex) {
        ApiResponse<?> errorResponse = new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidParameterException.class)
    public ResponseEntity<Object> handleValidationException(InvalidParameterException ex) {
        ApiResponse<?> errorResponse = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CnpjIndisponivelException.class)
    public ResponseEntity<Object> handleValidationException(CnpjIndisponivelException ex) {
        ApiResponse<?> errorResponse = new ApiResponse<>(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}