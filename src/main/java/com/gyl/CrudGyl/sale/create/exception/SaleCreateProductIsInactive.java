package com.gyl.CrudGyl.sale.create.exception;

public class SaleCreateProductIsInactive extends RuntimeException {
    public SaleCreateProductIsInactive(Long id) {
        super("Product of id " + id + " is inactive");
    }
}
