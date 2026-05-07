package com.gyl.ProductsMicroservice.product.update.exception;

public class ProductUpdateProductDoesNotExist extends RuntimeException {
    public ProductUpdateProductDoesNotExist(Long id) {
        super("Product of id " + id + " does not exist");
    }
}
