package com.gyl.CrudGyl.sale.create.exception;

public class SaleCreateProductDoesNotExist extends RuntimeException {
    public SaleCreateProductDoesNotExist(Long id) {
        super("Product of id " + id + " does not exist");
    }
}
