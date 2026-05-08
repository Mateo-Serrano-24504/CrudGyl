package com.gyl.SalesMicroservice.sale.create.exception;

public class SaleCreateProductFetchUnhandleableError extends RuntimeException {
    public SaleCreateProductFetchUnhandleableError(Exception e) {
        super("Provider received an unhandleable error: " + e.getMessage());
    }
}
