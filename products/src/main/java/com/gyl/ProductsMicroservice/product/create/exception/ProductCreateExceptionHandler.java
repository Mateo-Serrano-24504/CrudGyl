package com.gyl.ProductsMicroservice.product.create.exception;

import com.gyl.ProductsMicroservice.exception.ErrorFormat;
import com.gyl.ProductsMicroservice.product.create.controller.ProductCreateController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ProductCreateController.class)
public class ProductCreateExceptionHandler {

    @ExceptionHandler(ProductCreateProductTypeDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductTypeDoesNotExist(ProductCreateProductTypeDoesNotExist ex) {
        String prefix = "Error during product creation";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}