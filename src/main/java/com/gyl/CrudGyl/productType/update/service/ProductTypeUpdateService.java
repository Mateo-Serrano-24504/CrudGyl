package com.gyl.CrudGyl.productType.update.service;

import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateResponseDto;

public interface ProductTypeUpdateService {
    ProductTypeUpdateResponseDto update(Long id, ProductTypeUpdateRequestDto dto);
}
