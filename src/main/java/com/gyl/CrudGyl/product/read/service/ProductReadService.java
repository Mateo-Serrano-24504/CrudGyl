package com.gyl.CrudGyl.product.read.service;

import com.gyl.CrudGyl.product.read.dto.ProductReadResponseDto;

public interface ProductReadService {
    ProductReadResponseDto read(Long id);
}
