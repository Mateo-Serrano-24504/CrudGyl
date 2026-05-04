package com.gyl.CrudGyl.product.read.exception;

public class ProductReadProductDoesNotExist extends RuntimeException {
    public ProductReadProductDoesNotExist(Long id) {
        super("The product of id " + id + " does not exist");
    }
}
