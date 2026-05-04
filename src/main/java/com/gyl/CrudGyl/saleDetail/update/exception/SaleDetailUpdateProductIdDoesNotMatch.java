package com.gyl.CrudGyl.saleDetail.update.exception;

public class SaleDetailUpdateProductIdDoesNotMatch extends RuntimeException {
    public SaleDetailUpdateProductIdDoesNotMatch(Long expectedId, Long receivedId) {
        super("Expected product id " + expectedId + " but received " + receivedId);
    }
}
