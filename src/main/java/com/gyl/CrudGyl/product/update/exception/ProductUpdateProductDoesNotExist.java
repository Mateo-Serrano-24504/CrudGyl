package com.gyl.CrudGyl.product.update.exception;

public class ProductUpdateProductDoesNotExist extends RuntimeException {
    public ProductUpdateProductDoesNotExist(Long id) {
        super("Product of id " + id + " does not exist");
    }
}
