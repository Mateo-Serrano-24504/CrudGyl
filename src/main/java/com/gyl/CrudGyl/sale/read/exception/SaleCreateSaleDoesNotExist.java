package com.gyl.CrudGyl.sale.read.exception;

public class SaleCreateSaleDoesNotExist extends RuntimeException {
    public SaleCreateSaleDoesNotExist(Long id) {
        super("Sale of id " + id + " does not exist");
    }
}
