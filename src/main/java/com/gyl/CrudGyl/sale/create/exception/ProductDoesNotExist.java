package com.gyl.CrudGyl.sale.create.exception;

public class ProductDoesNotExist extends RuntimeException {
    public ProductDoesNotExist(Long id) {
        super("Product of id " + id + " does not exist");
    }
}
