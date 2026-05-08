package com.gyl.SalesMicroservice.sale.update.exception;

public class SaleUpdateClientDoesNotExist extends RuntimeException {
    public SaleUpdateClientDoesNotExist(Long id) {
        super("The client of id " + id + " does not exist");
    }
}
