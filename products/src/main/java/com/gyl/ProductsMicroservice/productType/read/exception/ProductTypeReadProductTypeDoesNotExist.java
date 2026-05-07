package com.gyl.ProductsMicroservice.productType.read.exception;

public class ProductTypeReadProductTypeDoesNotExist extends RuntimeException {
    public ProductTypeReadProductTypeDoesNotExist(Long id) {
        super("The product type of id " + id + " does not exist");
    }
}
