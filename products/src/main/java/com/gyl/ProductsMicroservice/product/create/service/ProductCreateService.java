package com.gyl.ProductsMicroservice.product.create.service;

import com.gyl.ProductsMicroservice.product.create.dto.ProductCreateRequestDto;
import com.gyl.ProductsMicroservice.product.create.dto.ProductCreateResponseDto;

public interface ProductCreateService {
    ProductCreateResponseDto create(ProductCreateRequestDto dto);
}
