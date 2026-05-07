package com.gyl.CrudGyl.product.update.exception;

import com.gyl.CrudGyl.exception.ErrorFormat;
import com.gyl.CrudGyl.product.update.controller.ProductUpdateController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ProductUpdateController.class)
public class ProductUpdateExceptionHandler {
    @ExceptionHandler(ProductUpdateProductDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductDoesNotExist(ProductUpdateProductDoesNotExist ex) {
        String prefix = "Error during product update";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
    @ExceptionHandler(ProductUpdateProductTypeDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductTypeDoesNotExist(ProductUpdateProductTypeDoesNotExist ex) {
        String prefix = "Error during product update";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}
