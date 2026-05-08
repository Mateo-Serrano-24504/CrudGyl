package com.gyl.SalesMicroservice.sale.create.exception;

public class SaleCreateProductDoesNotExist extends RuntimeException {
    public SaleCreateProductDoesNotExist(Long id) {
        super("Product of id " + id + " does not exist");
    }
}
