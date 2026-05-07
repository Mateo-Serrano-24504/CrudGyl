package com.gyl.CrudGyl.product.update.exception;

public class ProductUpdateProductIsInactive extends RuntimeException {
    public ProductUpdateProductIsInactive(Long id) {
        super("Product of id " + id + " is not active");
    }
}
