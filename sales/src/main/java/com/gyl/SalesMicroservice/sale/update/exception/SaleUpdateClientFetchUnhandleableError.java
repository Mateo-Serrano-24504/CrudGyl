package com.gyl.SalesMicroservice.sale.update.exception;

public class SaleUpdateClientFetchUnhandleableError extends RuntimeException {
    public SaleUpdateClientFetchUnhandleableError(Exception e) {
        super("Provider received an unhandleable error: " + e.getMessage());
    }
}
