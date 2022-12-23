package com.hsnbrji.numberconverter.advice;

import com.hsnbrji.numberconverter.exception.ConversionNotPossibleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice

public class ConversionNotPossibleAdvice {

    @ExceptionHandler(value = ConversionNotPossibleException.class)
    public ResponseEntity<Object> handleBadParamsException(ConversionNotPossibleException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
