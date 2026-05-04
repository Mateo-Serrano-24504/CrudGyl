package com.gyl.CrudGyl.product.create.exception;

public class ProductCreateProductTypeDoesNotExist extends RuntimeException {
    public ProductCreateProductTypeDoesNotExist(Long id) {
        super("Product type of id " + id + " does not exist");
    }
}
