package com.hsnbrji.numberconverter.advice;

import com.hsnbrji.numberconverter.exception.ConversionNotPossibleException;
import java.util.List;
import java.util.function.Function;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class InputNumberNullAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleBadParamsException(MethodArgumentNotValidException ex, WebRequest request) {
        List<Object> errors = ex.getBindingResult()
            .getAllErrors()
            .stream().map((Function<ObjectError, Object>) DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();
        return ResponseEntity.badRequest().body(errors);
    }

}
