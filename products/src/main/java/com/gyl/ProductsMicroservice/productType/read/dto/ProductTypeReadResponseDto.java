package com.gyl.ProductsMicroservice.productType.read.dto;

public record ProductTypeReadResponseDto (
        Long id,
        String name,
        String description
) {}
