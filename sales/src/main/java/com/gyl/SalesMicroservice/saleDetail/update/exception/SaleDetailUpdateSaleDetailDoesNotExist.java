package com.gyl.SalesMicroservice.saleDetail.update.exception;

public class SaleDetailUpdateSaleDetailDoesNotExist extends RuntimeException {
    public SaleDetailUpdateSaleDetailDoesNotExist(Long id) {
        super("Sale detail of id " + id + " does not exist");
    }
}
