package com.gyl.CrudGyl.sale.exception;

public class SaleDoesNotExist extends RuntimeException {
    public SaleDoesNotExist(Long id) {
        super("Sale of id " + id + " does not exist");
    }
}
