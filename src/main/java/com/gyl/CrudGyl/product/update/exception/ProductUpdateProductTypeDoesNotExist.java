package com.gyl.CrudGyl.product.update.exception;

public class ProductUpdateProductTypeDoesNotExist extends RuntimeException {
    public ProductUpdateProductTypeDoesNotExist(Long id) {
        super("Product type of id " + id + " does not exist");
    }
}
