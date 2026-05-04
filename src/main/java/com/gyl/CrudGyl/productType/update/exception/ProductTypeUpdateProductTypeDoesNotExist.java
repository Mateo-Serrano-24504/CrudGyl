package com.gyl.CrudGyl.productType.update.exception;

public class ProductTypeUpdateProductTypeDoesNotExist extends RuntimeException {
    public ProductTypeUpdateProductTypeDoesNotExist(Long id) {
        super("Product type of id " + id + " does not exist");
    }
}
