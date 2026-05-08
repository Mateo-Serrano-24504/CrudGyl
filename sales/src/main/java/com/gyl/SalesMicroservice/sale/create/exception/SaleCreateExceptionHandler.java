package com.gyl.SalesMicroservice.sale.create.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.sale.create.controller.SaleCreateController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(assignableTypes = SaleCreateController.class)
public class SaleCreateExceptionHandler {

    @ExceptionHandler(SaleCreateClientDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientDoesNotExist(SaleCreateClientDoesNotExist ex) {
        String prefix = "Error during sale creation";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }

    @ExceptionHandler(SaleCreateProductDoesNotExist.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductDoesNotExist(SaleCreateProductDoesNotExist ex) {
        String prefix = "Error during sale creation";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }

    @ExceptionHandler(SaleCreateProductIsInactive.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductIsInactive(SaleCreateProductIsInactive ex) {
        String prefix = "Error during sale creation";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }

    @ExceptionHandler(SaleCreateClientIsInactive.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientIsInactive(SaleCreateClientIsInactive ex) {
        String prefix = "Error during sale creation";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorFormat(prefix, List.of(ex.getMessage()))
        );
    }

    @ExceptionHandler(SaleCreateClientFetchError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientFetchError(SaleCreateClientFetchError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getErrorFormat());
    }

    @ExceptionHandler(SaleCreateClientFetchUnhandleableError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleClientFetchUnhandleableError(SaleCreateClientFetchUnhandleableError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorFormat("Error during fetch of client", List.of(ex.getMessage())));
    }

    @ExceptionHandler(SaleCreateProductFetchError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductFetchError(SaleCreateProductFetchError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getErrorFormat());
    }

    @ExceptionHandler(SaleCreateProductFetchUnhandleableError.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ErrorFormat> handleProductFetchUnhandleableError(SaleCreateProductFetchUnhandleableError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorFormat("Error during fetch of product", List.of(ex.getMessage())));
    }
}
