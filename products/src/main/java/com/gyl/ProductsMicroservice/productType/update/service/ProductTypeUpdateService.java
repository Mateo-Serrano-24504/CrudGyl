package com.gyl.ProductsMicroservice.productType.update.service;

import com.gyl.ProductsMicroservice.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.ProductsMicroservice.productType.update.dto.ProductTypeUpdateResponseDto;

public interface ProductTypeUpdateService {
    ProductTypeUpdateResponseDto update(Long id, ProductTypeUpdateRequestDto dto);
}
