package com.gyl.CrudGyl.product.update.exception;

public class ProductUpdateProductTypeIsInactive extends RuntimeException {
    public ProductUpdateProductTypeIsInactive(Long id) {
        super("Product type of id " + id + " is not active");
    }
}
