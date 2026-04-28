package com.gyl.CrudGyl.productType.read.exception;

import com.gyl.CrudGyl.exception.ErrorFormat;
import com.gyl.CrudGyl.productType.read.controller.ProductTypeReadController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ProductTypeReadController.class)
public class ProductTypeReadExceptionHandler {

    @ExceptionHandler(ProductTypeDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductTypeDoesNotExist(ProductTypeDoesNotExist ex) {
        String prefix = "Error during product type reading";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}