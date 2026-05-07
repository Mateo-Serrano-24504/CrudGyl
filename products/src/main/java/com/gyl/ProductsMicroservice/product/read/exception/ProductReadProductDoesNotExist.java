package com.gyl.ProductsMicroservice.product.read.exception;

public class ProductReadProductDoesNotExist extends RuntimeException {
    public ProductReadProductDoesNotExist(Long id) {
        super("The product of id " + id + " does not exist");
    }
}
