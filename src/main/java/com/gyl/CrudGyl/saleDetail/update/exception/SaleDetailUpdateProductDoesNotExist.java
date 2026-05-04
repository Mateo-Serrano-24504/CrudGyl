package com.gyl.CrudGyl.saleDetail.update.exception;

public class SaleDetailUpdateProductDoesNotExist extends RuntimeException {
    public SaleDetailUpdateProductDoesNotExist(Long id) {
        super("Product of id " + id + " does not exist");
    }
}
