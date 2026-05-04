package com.gyl.CrudGyl.sale.update.exception;

import com.gyl.CrudGyl.exception.ErrorFormat;
import com.gyl.CrudGyl.sale.update.controller.SaleUpdateController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = SaleUpdateController.class)
public class SaleUpdateExceptionHandler {
    @ExceptionHandler(SaleUpdateClientDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientDoeSNotExist(SaleUpdateClientDoesNotExist ex) {
        String prefix = "Error during sale update";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
    @ExceptionHandler(SaleUpdateSaleDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleSaleDoeSNotExist(SaleUpdateSaleDoesNotExist ex) {
        String prefix = "Error during sale update";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}
