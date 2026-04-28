package com.gyl.CrudGyl.productType.create.service;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;

public interface ProductTypeCreateService {
    ProductTypeCreateResponseDto create(ProductTypeCreateRequestDto dto);
}
