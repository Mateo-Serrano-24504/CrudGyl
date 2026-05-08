package com.gyl.SalesMicroservice.saleDetail.update.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.saleDetail.update.controller.SaleDetailUpdateController;
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

    @ExceptionHandler(SaleDetailUpdateProductIdDoesNotMatch.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductDoesNotExist(SaleDetailUpdateProductIdDoesNotMatch ex) {
        String message = "Error in sale detail update";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorFormat(message, List.of(ex.getMessage())));
    }

    @ExceptionHandler(SaleDetailUpdateProductFetchError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductFetchError(SaleDetailUpdateProductFetchError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getErrorFormat());
    }

    @ExceptionHandler(SaleDetailUpdateProductFetchUnhandleableError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductFetchUnhandleableError(SaleDetailUpdateProductFetchUnhandleableError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorFormat("Error during fetch of product", List.of(ex.getMessage())));
    }
}
