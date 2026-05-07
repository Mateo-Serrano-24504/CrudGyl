package com.gyl.ProductsMicroservice.productType.read.service;

import com.gyl.ProductsMicroservice.productType.read.dto.ProductTypeReadResponseDto;

public interface ProductTypeReadService {
    ProductTypeReadResponseDto read(Long id);
}
