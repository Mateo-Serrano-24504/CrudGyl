package com.gyl.ProductsMicroservice.product.update.exception;

public class ProductUpdateProductTypeDoesNotExist extends RuntimeException {
    public ProductUpdateProductTypeDoesNotExist(Long id) {
        super("Product type of id " + id + " does not exist");
    }
}
