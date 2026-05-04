package com.gyl.CrudGyl.saleDetail.update.exception;

import com.gyl.CrudGyl.exception.ErrorFormat;
import com.gyl.CrudGyl.saleDetail.update.controller.SaleDetailUpdateController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = SaleDetailUpdateController.class)
public class SaleDetailUpdateExceptionHandler {
    @ExceptionHandler(SaleDetailUpdateSaleDetailDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleSaleDetailDoesNotExist(SaleDetailUpdateSaleDetailDoesNotExist ex) {
        String message = "Error in sale detail update";
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorFormat(message, List.of(ex.getMessage())));
    }

    @ExceptionHandler(SaleDetailUpdateProductDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductDoesNotExist(SaleDetailUpdateProductDoesNotExist ex) {
        String message = "Error in sale detail update";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorFormat(message, List.of(ex.getMessage())));
    }
}
