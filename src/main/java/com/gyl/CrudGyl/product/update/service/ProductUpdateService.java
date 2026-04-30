package com.gyl.CrudGyl.product.update.service;

import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateResponseDto;

public interface ProductUpdateService {
    ProductUpdateResponseDto update(Long id, ProductUpdateRequestDto dto);
}
