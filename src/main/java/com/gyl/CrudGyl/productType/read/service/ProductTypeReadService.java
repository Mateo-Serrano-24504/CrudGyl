package com.gyl.CrudGyl.productType.read.service;

import com.gyl.CrudGyl.productType.read.dto.ProductTypeReadResponseDto;

public interface ProductTypeReadService {
    ProductTypeReadResponseDto read(Long id);
}
