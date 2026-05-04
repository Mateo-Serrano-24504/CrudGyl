package com.gyl.CrudGyl.sale.read.exception;

import com.gyl.CrudGyl.exception.ErrorFormat;
import com.gyl.CrudGyl.sale.read.controller.SaleReadController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = SaleReadController.class)
public class SaleReadExceptionHandler {
    @ExceptionHandler(SaleCreateSaleDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleSaleDoesNotExist(SaleCreateSaleDoesNotExist ex) {
        String prefix = "Error during sale reading";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}
