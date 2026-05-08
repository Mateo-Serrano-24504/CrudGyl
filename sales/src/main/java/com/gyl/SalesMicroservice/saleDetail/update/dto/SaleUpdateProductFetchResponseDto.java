package com.gyl.SalesMicroservice.saleDetail.update.dto;

public record SaleUpdateProductFetchResponseDto(
        Long id,
        String name,
        Double price,
        Long stock,
        Long productTypeId
) {}
