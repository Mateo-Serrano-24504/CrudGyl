package com.gyl.SalesMicroservice.sale.create.exception;

public class SaleCreateClientFetchUnhandleableError extends RuntimeException {
    public SaleCreateClientFetchUnhandleableError(Exception e) {
        super("Provider received an unhandleable error: " + e.getMessage());
    }
}
