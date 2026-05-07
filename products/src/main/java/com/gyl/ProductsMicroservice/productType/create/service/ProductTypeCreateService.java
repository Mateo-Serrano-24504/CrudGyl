package com.gyl.ProductsMicroservice.productType.create.service;

import com.gyl.ProductsMicroservice.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.ProductsMicroservice.productType.create.dto.ProductTypeCreateResponseDto;

public interface ProductTypeCreateService {
    ProductTypeCreateResponseDto create(ProductTypeCreateRequestDto dto);
}
