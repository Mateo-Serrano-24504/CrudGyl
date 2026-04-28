package com.gyl.CrudGyl.product.read.exception;

public class ProductDoesNotExist extends RuntimeException {
    public ProductDoesNotExist(Long id) {
        super("The product of id " + id + " does not exist");
    }
}
