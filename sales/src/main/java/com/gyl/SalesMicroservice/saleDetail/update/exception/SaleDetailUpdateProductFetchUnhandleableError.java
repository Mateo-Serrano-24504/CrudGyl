package com.gyl.SalesMicroservice.saleDetail.update.exception;

public class SaleDetailUpdateProductFetchUnhandleableError extends RuntimeException {
    public SaleDetailUpdateProductFetchUnhandleableError(Exception e) {
        super("Provider received an unhandleable error: " + e.getMessage());
    }
}
