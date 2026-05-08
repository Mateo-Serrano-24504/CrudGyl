package com.gyl.SalesMicroservice.sale.create.exception;

public class SaleCreateClientIsInactive extends RuntimeException {
    public SaleCreateClientIsInactive(Long id) {
        super("Client of id " + id + " is inactive");
    }
}
