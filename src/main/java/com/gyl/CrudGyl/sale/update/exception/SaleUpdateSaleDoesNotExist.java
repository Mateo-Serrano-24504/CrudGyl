package com.gyl.CrudGyl.sale.update.exception;

public class SaleUpdateSaleDoesNotExist extends RuntimeException {
    public SaleUpdateSaleDoesNotExist(Long id) {
        super("The sale of id " + id + " does not exist");
    }
}
