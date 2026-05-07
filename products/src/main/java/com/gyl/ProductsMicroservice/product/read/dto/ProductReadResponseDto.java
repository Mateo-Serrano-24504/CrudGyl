package com.gyl.ProductsMicroservice.product.read.dto;

public record ProductReadResponseDto (
        Long id,
        String name,
        Double price,
        Long stock,
        Long productTypeId
) {}
