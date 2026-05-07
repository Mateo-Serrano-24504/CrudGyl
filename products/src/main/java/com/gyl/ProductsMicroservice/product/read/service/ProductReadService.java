package com.gyl.ProductsMicroservice.product.read.service;

import com.gyl.ProductsMicroservice.product.read.dto.ProductReadResponseDto;

public interface ProductReadService {
    ProductReadResponseDto read(Long id);
}
