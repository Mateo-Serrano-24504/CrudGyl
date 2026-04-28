package com.gyl.CrudGyl.product.create.exception;

public class ProductTypeDoesNotExist extends RuntimeException {
    public ProductTypeDoesNotExist(Long id) {
        super("Product type of id " + id + " does not exist");
    }
}
