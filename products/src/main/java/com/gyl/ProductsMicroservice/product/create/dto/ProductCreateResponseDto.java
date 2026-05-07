package com.gyl.ProductsMicroservice.product.create.dto;

public record ProductCreateResponseDto(
        Long id,
        String name,
        Double price,
        Long stock,
        Long productTypeId
) {}
