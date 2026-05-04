package com.gyl.CrudGyl.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleValidationError(MethodArgumentNotValidException ex) {
        String prefix = "Validation error";
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest()
                .body(new ErrorFormat(prefix, errors));
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorFormat> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String prefix = "Database constraint violation occurred";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}