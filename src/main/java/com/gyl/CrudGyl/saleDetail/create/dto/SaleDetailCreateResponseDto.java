package com.gyl.CrudGyl.saleDetail.create.dto;

public record SaleDetailCreateResponseDto(
        Long id,
        Long amount,
        Double unitPrice,
        Double subtotal,
        Long clientId,
        Long saleId
) {}
