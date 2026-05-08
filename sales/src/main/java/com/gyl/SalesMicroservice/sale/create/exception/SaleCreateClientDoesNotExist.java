package com.gyl.SalesMicroservice.sale.create.exception;

public class SaleCreateClientDoesNotExist extends RuntimeException {
    public SaleCreateClientDoesNotExist(Long id) {
        super("Client of id " + id + " does not exist");
    }
}
