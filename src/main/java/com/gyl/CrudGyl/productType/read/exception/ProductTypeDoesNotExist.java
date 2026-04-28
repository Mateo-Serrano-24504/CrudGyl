package com.gyl.CrudGyl.productType.read.exception;

public class ProductTypeDoesNotExist extends RuntimeException {
    public ProductTypeDoesNotExist(Long id) {
        super("The product type of id " + id + " does not exist");
    }
}
