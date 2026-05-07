package com.gyl.ClientsMicroservice.client.read.exception;

import com.gyl.ClientsMicroservice.client.read.controller.ClientReadController;
import com.gyl.ClientsMicroservice.exception.ErrorFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ClientReadController.class)
public class ClientReadExceptionHandler {
    @ExceptionHandler(ClientReadClientDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientDoesNotExist(ClientReadClientDoesNotExist ex) {
        String prefix = "Error during client reading";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}
