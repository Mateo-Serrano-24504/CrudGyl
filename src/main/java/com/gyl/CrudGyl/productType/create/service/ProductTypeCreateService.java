package com.gyl.CrudGyl.productType.create.service;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;

public interface ProductTypeCreateService {
    ProductTypeCreateResponseDto create(ProductTypeCreateDto dto);
}
