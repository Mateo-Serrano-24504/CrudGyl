package com.gyl.CrudGyl.product.read.exception;

import com.gyl.CrudGyl.exception.ErrorFormat;
import com.gyl.CrudGyl.product.read.controller.ProductReadController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ProductReadController.class)
public class ProductReadExceptionHandler {

    @ExceptionHandler(ProductReadProductDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductDoesNotExist(ProductReadProductDoesNotExist ex) {
        String prefix = "Error during product reading";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}