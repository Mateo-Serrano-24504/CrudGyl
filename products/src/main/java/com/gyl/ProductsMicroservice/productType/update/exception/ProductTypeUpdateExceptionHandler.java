package com.gyl.ProductsMicroservice.productType.update.exception;

import com.gyl.ProductsMicroservice.exception.ErrorFormat;
import com.gyl.ProductsMicroservice.productType.update.controller.ProductTypeUpdateController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = ProductTypeUpdateController.class)
public class ProductTypeUpdateExceptionHandler {
    @ExceptionHandler(ProductTypeUpdateProductTypeDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductTypeDoesNotExist(ProductTypeUpdateProductTypeDoesNotExist ex) {
        String prefix = "Error during product type update";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }
}
