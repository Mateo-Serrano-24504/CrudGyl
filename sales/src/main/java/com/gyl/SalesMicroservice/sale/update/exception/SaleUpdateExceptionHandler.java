package com.gyl.SalesMicroservice.sale.update.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.sale.update.controller.SaleUpdateController;
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

    @ExceptionHandler(SaleUpdateClientFetchError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientFetchError(SaleUpdateClientFetchError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getErrorFormat());
    }

    @ExceptionHandler(SaleUpdateClientFetchUnhandleableError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientFetchUnhandleableError(SaleUpdateClientFetchUnhandleableError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorFormat("Error during fetch of client", List.of(ex.getMessage())));
    }
}
