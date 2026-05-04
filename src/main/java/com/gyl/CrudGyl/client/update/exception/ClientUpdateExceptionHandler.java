package com.gyl.CrudGyl.client.update.exception;

import com.gyl.CrudGyl.client.update.controller.ClientUpdateController;
import com.gyl.CrudGyl.exception.ErrorFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ClientUpdateController.class)
public class ClientUpdateExceptionHandler {
    @ExceptionHandler(ClientUpdateClientDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientDoesNotExist(ClientUpdateClientDoesNotExist ex) {
        String prefix = "Error during client update";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}
