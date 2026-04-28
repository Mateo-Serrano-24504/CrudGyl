package com.gyl.CrudGyl.product.create.service;

import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;

public interface ProductCreateService {
    ProductCreateResponseDto create(ProductCreateRequestDto dto);
}
