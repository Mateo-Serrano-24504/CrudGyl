package com.gyl.ProductsMicroservice.product.update.service;

import com.gyl.ProductsMicroservice.product.update.dto.ProductUpdateRequestDto;
import com.gyl.ProductsMicroservice.product.update.dto.ProductUpdateResponseDto;

public interface ProductUpdateService {
    ProductUpdateResponseDto update(Long id, ProductUpdateRequestDto dto);
}
